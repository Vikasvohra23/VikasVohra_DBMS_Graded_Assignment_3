package com.gl.ticketTracker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.ticketTracker.dto.TicketDto;
import com.gl.ticketTracker.service.TicketService;

@Controller
public class TicketController {

    private final TicketService ticketService;

    // Constructor-based dependency injection for TicketService
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    // Handler for GET request to display all tickets
    @GetMapping("/admin/tickets")
    public String listTickets(Model model) {
        List<TicketDto> tickets = ticketService.findAllTickets();
        model.addAttribute("tickets", tickets);
        return "admin/tickets"; // Return the view name
    }

    // Handler for GET request to show the form for creating a new ticket
    @GetMapping("/admin/tickets/newTicket")
    public String showNewTicketForm(Model model) {
        TicketDto ticketDto = new TicketDto();
        model.addAttribute("ticket", ticketDto);
        return "admin/create_ticket"; // Return the view name for creating a ticket
    }

    // Handler for POST request to create a new ticket
    @PostMapping("/admin/tickets")
    public String createTicket(@Valid @ModelAttribute("ticket") TicketDto ticketDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("ticket", ticketDto);
            return "admin/create_ticket"; // Return to the form if there are validation errors
        }
        ticketDto.setUrl(generateUrl(ticketDto.getTitle()));
        ticketService.createTicket(ticketDto);
        return "redirect:/admin/tickets"; // Redirect to the list of tickets after saving
    }

    // Utility method to generate a URL-friendly string from the ticket title
    private static String generateUrl(String ticketTitle) {
        String title = ticketTitle.trim().toLowerCase();
        String url = title.replaceAll("\\s+", "-");
        url = url.replaceAll("[^A-Za-z0-9]", "=");
        return url;
    }

    // Handler for GET request to show the form for editing an existing ticket
    @GetMapping("/admin/tickets/{ticketId}/edit")
    public String showEditTicketForm(@PathVariable("ticketId") Long ticketId, Model model) {
        TicketDto ticketDto = ticketService.findTickerById(ticketId);
        model.addAttribute("ticket", ticketDto);
        return "admin/edit_ticket"; // Return the view name for editing a ticket
    }

    // Handler for POST request to update an existing ticket
    @PostMapping("/admin/tickets/{ticketId}")
    public String updateTicket(@PathVariable("ticketId") long ticketId,
                               @Valid @ModelAttribute("ticket") TicketDto ticketDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("ticket", ticketDto);
            return "admin/edit_ticket"; // Return to the form if there are validation errors
        }
        ticketDto.setId(ticketId);
        ticketService.updateTicket(ticketDto);
        return "redirect:/admin/tickets"; // Redirect to the list of tickets after updating
    }

    // Handler for GET request to delete a ticket
    @GetMapping("/admin/tickets/{ticketId}/delete")
    public String deleteTicket(@PathVariable("ticketId") Long ticketId) {
        ticketService.deleteTicket(ticketId);
        return "redirect:/admin/tickets"; // Redirect to the list of tickets after deleting
    }

    // Handler for GET request to view a ticket
    @GetMapping("/admin/ticket/{ticketUrl}/view")
    public String viewTicket(@PathVariable("ticketUrl") String ticketUrl, Model model) {
        TicketDto ticketDto = ticketService.findTicketByUrl(ticketUrl);
        model.addAttribute("ticket", ticketDto);
        return "admin/view_ticket"; // Return the view name for viewing a ticket
    }

    // Handler for GET request to search tickets
    @GetMapping("/admin/tickets/search")
    public String searchTickets(@RequestParam(value = "query") String query, Model model) {
        List<TicketDto> tickets = ticketService.searchTickets(query);
        model.addAttribute("tickets", tickets);
        return "admin/tickets"; // Return the view name with the search results
    }
}
