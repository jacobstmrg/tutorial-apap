import React, { useState } from "react";

import List from "./components/List";
import listMovies from "movies.json";
import "./App.css";



function App() {
    const[favItems, setFavItems] = useState(() => []);

    function handleItemClick(item){
        const newItems = [...favItems];
        const newItem = { ...item};

        const targetInd = newItems.findIndex(it => it.id === newItem.id);
        if (targetInd < 0) newItems.push(newItem);
        else newItems.splice(targetInd, 1);

        setFavItems(newItems);
    }
    return(
        <div className="container-fluid">
            <h1 className="text-center mt-3 mb-0">Favorite Movie App</h1>
            <p className="text-center text-secondary text-sm font-italic">
                (This is a <strong>function-based</strong> application)
            </p>
            <div className="container pt-3">
                <div className="row">
                    <div className="col-sm">
                        <List
                            title="List Movies"
                            items={listMovies}
                            onItemClick={handleItemClick}
                            />
                    </div>
                    <div className="col-sm">
                        <List
                            title="My Favorites"
                            items={favItems}
                            onItemClick={handleItemClick}
                            />
                    </div>
                </div>
            </div>
        </div>
    );
}
export default App;