import { RouterModule } from '@angular/router';
import { EventsListContainer } from './containers/events-list/events-list.container';
import { EventDetailsContainer } from './containers/event-details/event-details.container';
import { AuthenticationContainer } from './containers/authentication/authentication.container';
import { AuthenticatedGuard } from './authenticated.guard';

export const routes = [
  {
    path: '',
    component: EventsListContainer,
    canActivate: [AuthenticatedGuard],
  },
  {
    path: 'events/:eventId',
    component: EventDetailsContainer,
    canActivate: [AuthenticatedGuard],
  },
  {
    path: 'auth',
    component: AuthenticationContainer
  },
];
export const routing = RouterModule.forRoot(routes);
