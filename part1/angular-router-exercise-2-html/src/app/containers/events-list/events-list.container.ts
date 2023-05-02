import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { EventService } from '../../services/event.service';

@Component({
  selector: 'events-list',
  templateUrl: './events-list.container.html',
  styles: [
    `
    th, td { font-size: 16px; padding:5px 10px;}
  `,
  ],
})
export class EventsListContainer {
  events;
  constructor(private eventService: EventService, private router: Router) {
    this.events = eventService.getEvents();
  }

  openDetails(id) {
    this.router.navigate(['events', id]);
  }
}
