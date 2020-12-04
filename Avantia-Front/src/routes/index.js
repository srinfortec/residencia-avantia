import React from 'react';

import { Switch, Route } from 'react-router-dom';

import login from '../screens/login';
import home from '../screens/home';
import cameras from '../screens/cameras';
import consultar from '../screens/consultar';
import cadastrologin from '../screens/casdastroLogin'


const Routes = () => (
  <Switch>
    <Route path="/" exact component={login} />
    <Route path="/home" exact component={home} />
    <Route path="/cameras" exact component={cameras} />
    <Route path="/consultar" exact component={consultar} />
    <Route path="/cadastroLogin" exact component={cadastrologin} />
  </Switch>
);
export default Routes;
