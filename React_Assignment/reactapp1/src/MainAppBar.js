import React,{ Component } from 'react';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
class MainAppBar extends Component{
    render(){
        return <div>
            <AppBar>
                <Toolbar>
                    Home
                </Toolbar>
            </AppBar>
        </div>
    }
}
export default MainAppBar;