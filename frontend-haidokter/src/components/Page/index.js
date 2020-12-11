import React from 'react';
import classes from "./styles.module.css";

const Page = ({total, interval, current, handleClick}) =>{
    const count = Math.ceil(total/interval) || 1
    return(
        <div className={classes.container}>
            {[...Array(count)].map((_x,i)=>(
                <span
                key={i}
                onClick={() => handleClick(i)}
                style={{fontWeight: current===i && "bold"}}
                className={classes.page}
                >{
                    i+1
                }

                </span>
            ))}
        </div>
    );
};
export default Page;