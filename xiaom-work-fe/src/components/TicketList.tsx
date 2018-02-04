import * as React from 'react';
import withStyles, { WithStyles, StyleRulesCallback } from 'material-ui/styles/withStyles';
import Ticket from './Ticket';

const styles: StyleRulesCallback = (theme) => ({
  ticketList: {

  }
});

interface TicketListProps {
  tickets: Array<object>;
}

function TicketList(props: TicketListProps & WithStyles) {
  const {classes, tickets} = props;
  return (
    <div className={classes.ticketList}>
      {tickets.map(ticket => (
        <Ticket entity={ticket}/>
      ))}
    </div>
  );
}

export default withStyles(styles)<TicketListProps>(TicketList);
