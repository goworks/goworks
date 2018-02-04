import * as React from 'react';
import withStyles, { WithStyles, StyleRulesCallback } from 'material-ui/styles/withStyles';

const styles: StyleRulesCallback = (theme) => ({
  ticket: {

  }
});

interface TicketProps {
  entity: object;
}

function Ticket(props: TicketProps & WithStyles) {
  const {classes} = props;
  return (
    <div className={classes.ticket}>
      TODO
    </div>
  );
}

export default withStyles(styles)<TicketProps>(Ticket);
