import * as React from 'react';
import Button from 'material-ui/Button';
import withStyles, { WithStyles, StyleRulesCallback } from 'material-ui/styles/withStyles';
import Reboot from 'material-ui/Reboot';
import './App.css';

const styles: StyleRulesCallback<'root'> = (theme) => ({
  root: {
    flexGrow: 1,
  },
});

type State = {
  open: boolean;
};

class App extends React.Component<WithStyles<'root'>, State> {
  render() {
    const {classes} = this.props;

    return (
      <div className={classes.root}>
        <Reboot/>
        <Button raised={true} color="primary">
          Hello World
        </Button>
      </div>
    );
  }
}

export default withStyles(styles)<{}>(App);
