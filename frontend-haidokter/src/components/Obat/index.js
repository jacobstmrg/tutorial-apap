import React from "react";
import Button from "../Button";
import classes from "./styles.module.css"


const Obat = (props)=>{
    const{nama,kuantitas}=props;
    return(
        <div className={classes.obat} variant="primary">
            {`${nama} (${kuantitas})`}
        </div>
    );
};

export default Obat;