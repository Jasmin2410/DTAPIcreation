package controllers;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v3/app/events")
public class EventController {

    private List<Event> events = new ArrayList<>();

    // GET /api/v3/app/events?id=:event_id - Get event by its id
    @GetMapping("")
    public Event getEventById(@RequestParam String id) {
        Event event = events.stream()
                .filter(e -> e.getUid().equals(id))
                .findFirst()
                .orElse(null);

        if (event == null) {
            throw new ResourceNotFoundException("Event not found");
        }

        return event;
    }

    // GET /api/v3/app/events?type=latest&limit=5&page=1 - Get latest events with pagination
    @GetMapping("")
    public List<Event> getLatestEvents(@RequestParam(defaultValue = "5") int limit,
                                      @RequestParam(defaultValue = "1") int page) {
        int startIndex = (page - 1) * limit;
        int endIndex = Math.min(startIndex + limit, events.size());

        return events.subList(startIndex, endIndex);
    }

    // POST /api/v3/app/events - Create a new event
    @PostMapping("")
    public String createEvent(@RequestBody Event event) {
        String eventId = UUID.randomUUID().toString();
        event.setUid(eventId);
        events.add(event);
        return eventId;
    }

    // PUT /api/v3/app/events/:id - Update an existing event
    @PutMapping("/{id}")
    public String updateEvent(@PathVariable String id, @RequestBody Event event) {
        Event existingEvent = events.stream()
                .filter(e -> e.getUid().equals(id))
                .findFirst()
                .orElse(null);

        if (existingEvent == null) {
            throw new ResourceNotFoundException("Event not found");
        }

        existingEvent.setName(event.getName());
        existingEvent.setTagline(event.getTagline());
        // Update other properties accordingly

        return id;
    }

    // DELETE /api/v3/app/events/:id - Delete an event by its id
    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable String id) {
        events.removeIf(e -> e.getUid().equals(id));
    }
}
