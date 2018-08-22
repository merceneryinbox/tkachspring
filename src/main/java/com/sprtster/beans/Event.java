package com.sprtster.beans;

import lombok.Data;

import java.text.DateFormat;
import java.util.Date;

@Data
public class Event {
    int id;
    private String evengMsg;
    Date date;
    DateFormat dateFormat;

    public Event(Date date, DateFormat dateFormat) {
        this.date = date;
        this.dateFormat = dateFormat;
    }

    public int getId() {
        return this.id;
    }

    public String getEvengMsg() {
        return this.evengMsg;
    }

    public Date getDate() {
        return this.date;
    }

    public void setId(int id) {
        this.id = (int) (Math.random() + 1) * 1_000_000;
    }

    public void setEvengMsg(String evengMsg) {
        this.evengMsg = evengMsg;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Event)) {
            return false;
        }
        final Event other = (Event) o;
        if (!other.canEqual((Object) this)) {
            return false;
        }
        if (this.getId() != other.getId()) {
            return false;
        }
        final Object this$evengMsg = this.getEvengMsg();
        final Object other$evengMsg = other.getEvengMsg();
        if (this$evengMsg == null ? other$evengMsg != null : !this$evengMsg.equals(other$evengMsg)) {
            return false;
        }
        final Object this$date = this.getDate();
        final Object other$date = other.getDate();
        if (this$date == null ? other$date != null : !this$date.equals(other$date)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getId();
        final Object $evengMsg = this.getEvengMsg();
        result = result * PRIME + ($evengMsg == null ? 43 : $evengMsg.hashCode());
        final Object $date = this.getDate();
        result = result * PRIME + ($date == null ? 43 : $date.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Event;
    }

    public String toString() {
        return "Event(id=" + this.getId() + ", evengMsg=" + this.getEvengMsg() + ", date=" +
               dateFormat.format(this.getDate()) + ")";
    }
}
