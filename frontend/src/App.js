import React from "react";

import List from "components/List";
import listMovies from "movies.json";
import EmptyState from './components/EmptyState';
import "./App.css";

export default class App extends React.Component{
  handleItemClick = item => {
    const newItems = [...this.state.favItems];
    const newItem = { ...item };

    const targetInd = newItems.findIndex(it => it.id === newItem.id);
    if (targetInd < 0) newItems.push(newItem);

    this.setState({ favItems: newItems });
  };

  handleFavoriteClick = item => {
    const newItems = [...this.state.favItems];
    const newItem = { ...item };

    const targetInd = newItems.findIndex(it => it.id === newItem.id);
    if (targetInd < 0) newItems.push(newItem);
    else newItems.splice(targetInd, 1);

    this.setState({ favItems: newItems });
  };

  deleteAll = item =>{
    this.setState({ favItems:[]})
  };
  
  state = {
    favItems: [],
    listFavorites: false
  };

  toggleFavorite = () => {
    this.setState(currentState => ({
      listFavorites: !currentState.listFavorites
    }));
  };

  render(){
    const { favItems, listFavorites } = this.state;

    let emptyState;
    if (favItems.length === 0) {
      emptyState = <EmptyState/>
    }
    
    return (
      <div className="container-fluid">
        <h1 className="text-center mt-3 mb-0">Favorites Movie App</h1>
        <p className="text-center text-secondary text-sm font-italic">
          (This is a <strong>class-based</strong> application)
        </p>
        <div className="d-flex justify-content-center align-items-center">
          <label className="switch">
            <input type="checkbox" onClick={this.toggleFavorite} />
            <span class="slider round"></span>
          </label>
          <h3 className="fav-margin col-2">Show Favorites</h3>
        </div>
        <div className={`text-center ${favItems.length > 0 ? "d-block" : "d-none"}`}>
          <label>
            <button className="btn btn-danger" onClick={this.deleteAll}>Delete All Favorites</button>
          </label>
        </div>
        <div className="container pt-3">
          <div className="row">
            <div className="col-sm">
              <List
                title="ListMovies"
                items={listMovies}
                onItemClick={this.handleItemClick}
              />
            </div>
            <div className={`col-sm ${listFavorites ? "d-block" : "d-none"}`}>
              <List
                title="My Favorites"
                items={favItems}
                onItemClick={this.handleFavoriteClick}
              />
              {emptyState}
            </div>
          </div>
        </div>
      </div>
    );
  }
}