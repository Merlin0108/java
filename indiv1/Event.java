package indiv1;

import java.time.LocalDateTime;


class Event {
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String type;  // "work" or "personal"

    public Event(String name, LocalDateTime startTime, LocalDateTime endTime, String type) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getType() {
        return type;
    }

    public boolean overlapsWith(Event other) {
        return (this.startTime.isBefore(other.endTime) && this.endTime.isAfter(other.startTime));
    }

    @Override
    public String toString() {
        return String.format("%s: %s - %s (%s)", name, startTime, endTime, type);
    }
}