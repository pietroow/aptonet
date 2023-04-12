import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EventService } from '../../services/event.service';

@Component({
  selector: 'event-details',
  template: `
    <h4>Event Details</h4>
    <div>
    <div>{{event.name}}</div>
    <div>{{event.date}} </div>      
    <div>{{event.time}}</div>
    <div>{{event.location.address}}, {{event.location.city}}, {{event.location.country}}</div>
    </div>
    <div class="back">
      <a [routerLink]="['']">< Back to events</a>
    </div>
  `,
  styles: [
    `
    .back { margin-top:10px; }
  `,
  ],
})
export class EventDetailsContainer {
  event: any;

  constructor(
    private eventService: EventService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.event = this.eventService.getEvent(id);
  }
}
