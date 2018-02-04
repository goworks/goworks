import * as React from 'react';
import Button from 'material-ui/Button';
import Grid from 'material-ui/Grid';
import withStyles, { WithStyles, StyleRulesCallback } from 'material-ui/styles/withStyles';
import Reboot from 'material-ui/Reboot';
import './App.css';
import TicketList from './components/TicketList';

const styles: StyleRulesCallback<'root'> = (theme) => ({
  root: {
    flexGrow: 1,
    margin: '10px',
  },
});

type State = {
  open: boolean;
};

const tickets: Array<object> = [{

}];

class App extends React.Component<WithStyles<'root'>, State> {
  render() {
    const {classes} = this.props;


    return (
      <div className={classes.root}>
        <Reboot/>
        <Grid
          container={true}
          alignItems="center"
          direction="row"
          justify="center"
        >
          <Grid item={true} xs={12} sm={8}>
            <Button raised={true} color="primary">
              Hello World
            </Button>
            <TicketList tickets={tickets} />
          </Grid>
        </Grid>
      </div>
    );
  }
}

export default withStyles(styles)<{}>(App);
