package com.keysoft.controller;


import com.keysoft.entity.*;
import com.keysoft.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/tza")
public class TrackZillaController {

    @Autowired
    private IApplicationService applicationService;

    @Autowired
    private ITicketService ticketService;

    @Autowired
    private IReleaseService releaseService;

    @Autowired
    private IBugService bugService;

    @Autowired
    private IEnhancementService enhancementService;

    @PostMapping("/application")
    public ResponseEntity<Void> addApplication(@RequestBody Application application, UriComponentsBuilder builder) {
        boolean flag= applicationService.addApplication(application);
        if(!flag) return new ResponseEntity<>(HttpStatus.CONFLICT);

        HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setLocation(builder.path("/application/{id}").buildAndExpand(application.getId()).toUri());
        return  new ResponseEntity<>(httpHeaders,HttpStatus.CREATED);
    }

    @GetMapping("/application/{id}")
    public ResponseEntity<Application> getApplicationById(@PathVariable("id") int id) {
        Application application = applicationService.getApplicationById(id);
        return new ResponseEntity<>(application,HttpStatus.OK);

    }

    @PutMapping("/application")
    public ResponseEntity<Application> updateApplication(@RequestBody Application application) {
        applicationService.updateApplication(application);
        return new ResponseEntity<>(application,HttpStatus.OK);
    }

    @DeleteMapping("/application/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable("id") int id) {
        applicationService.deleteApplicationById(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }



    //Tickets
    @GetMapping("/ticket/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable("id") Integer id){
        Ticket ticket = ticketService.getTicketById(id);
        return new ResponseEntity<>(ticket,HttpStatus.OK);
    }

    @GetMapping("/tickets")
    public ResponseEntity<List<Ticket>> getAllTickets(){
        List<Ticket> ticketList = ticketService.getAllTickets();
        return new ResponseEntity<>(ticketList,HttpStatus.OK);
    }

    @PostMapping("/ticket")
    public ResponseEntity<Void> addTicket(@RequestBody Ticket ticket,UriComponentsBuilder builder){
        ticketService.addTicket(ticket);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(builder.path("/ticket/{id}").buildAndExpand(ticket.getId()).toUri());
        return new ResponseEntity<>(httpHeaders,HttpStatus.CREATED);
    }

    @PutMapping("/ticket")
    public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket ticket){
        ticketService.updateTicket(ticket);
        return new ResponseEntity<>(ticket,HttpStatus.OK);
    }

    @DeleteMapping("/ticket/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable("id") Integer id){
        ticketService.deleteTicket(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("ticket/{id}")
    public ResponseEntity<Ticket> closeTicket(@PathVariable("id") Integer id){
        ticketService.closeTicket(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    //Release
    @PostMapping("/release")
    public ResponseEntity<Void> addRelease(@RequestBody Release release, UriComponentsBuilder builder){
        releaseService.addRelease(release);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/release").buildAndExpand(release.getId()).toUri());
        return new ResponseEntity<>(headers,HttpStatus.CREATED);
    }

    @PutMapping("/release/{appId}/{releaseId}")
    public ResponseEntity<Void> addAppToRelease(@PathVariable("appId") Integer appId,@PathVariable("releaseId") Integer releaseId,UriComponentsBuilder builder) {
        releaseService.addApplication(appId,releaseId);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/bug")
    public ResponseEntity<Void> addBug(@RequestBody Bug bug,UriComponentsBuilder builder) {
        bugService.addBug(bug);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/bug").buildAndExpand(bug.getId()).toUri());
        return  new ResponseEntity<>(headers,HttpStatus.CREATED);

    }

    @GetMapping("/severeBugs")
    public ResponseEntity<List<Bug>> getSevereBugs() {
        List<Bug> severeBugsList=bugService.getSevereBugs();
        return new ResponseEntity<>(severeBugsList,HttpStatus.OK);

    }

    @PostMapping("/enhancement")
    public ResponseEntity<Void> addEnhancement(@RequestBody Enhancement enhancement, UriComponentsBuilder builder) {
        enhancementService.addEnhancement(enhancement);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/enhancement").buildAndExpand(enhancement.getId()).toUri());
        return  new ResponseEntity<>(headers,HttpStatus.CREATED);

    }


    @GetMapping("/ticketsWithApps")
    public ResponseEntity<List<Enhancement>> getTicketsWithApps() {
        List<Enhancement> enhancementList=enhancementService.getTicketsWithApps();
        return new ResponseEntity<>(enhancementList,HttpStatus.OK);
    }

    @GetMapping("/findTicketsByReleaseId/{id}")
    public ResponseEntity<List<Ticket>> findTicketsByReleaseId(@PathVariable("id") int releaseId) {
        List<Ticket> ticketsList = ticketService.findTicketsByReleaseId(releaseId);
        return new ResponseEntity<>(ticketsList,HttpStatus.OK);
    }


}
