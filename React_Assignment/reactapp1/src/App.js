import React, { Component } from 'react';
import './App.css';
import MainAppBar from './MainAppBar';
import Items from './Items';
import { connect } from 'react-redux';
class App extends Component {
//  clickaction=()=>{
//     type:onclick;
//   }
  render() {
    return (<div>
          {/* <Home></Home> */}
          <div float="left">
            <a href="#">Admin</a>
            <a href="#">ShowItems</a>
          </div>
          <div><MainAppBar></MainAppBar></div><hr/>
          <div><Items></Items></div>
          <div>{this.props.input}</div>
          <button onClick={this.props.changeInput}>Input</button>
          </div>
    );
  
  }
}
const mapDispachToProps=(dispach)=>{
  return {
    changeInput:()=>dispach({type:'click'})
  }
}
const mapStateToProps=(state)=>{
  return {
    input:state.input
  }
}

export default connect(mapStateToProps,mapDispachToProps)(App)
