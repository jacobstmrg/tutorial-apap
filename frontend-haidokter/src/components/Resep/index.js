import React from "react";
import classes from "./styles.module.css";
import Button from "../../components/Button";
import Obat from "../../components/Obat";

const Resep = (props) => {
    const { noResep, namaDokter, namaPasien, catatan, listObat, handleEdit, handleDelete } = props;
    return (
        <div className={classes.resep}>
            <h3>{`Resep Nomor ${noResep}`}</h3>
            <p>{`Nama Dokter: ${namaDokter}`}</p>
            <p>{`Nama Pasien: ${namaPasien}`}</p>
            <p>{`Nama Catatan: ${catatan}`}</p>
            <p>List Obat:</p>
            {listObat.length == 0 ? <p className={classes.tidakAdaObat}>Resep tidak memiliki obat</p>:""}
            <div className={classes.listItem}>
                {listObat.map((item) => (
                                <Obat
                                    nama={item.nama}
                                    kuantitas={item.kuantitas} />
                                ))}
                </div>
            <Button onClick={handleEdit} variant="success">
            Edit
            </Button>
            <Button onClick={handleDelete} variant="danger">
            Delete
            </Button>
        </div>
    );
};
export default Resep;  