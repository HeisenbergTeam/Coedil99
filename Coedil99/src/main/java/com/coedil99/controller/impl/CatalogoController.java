package com.coedil99.controller.impl;

import com.coedil99.modello_di_dominio.DAOFactory;
import com.coedil99.modello_di_dominio.DescrizionePezzo;
import com.coedil99.modello_di_dominio.Fornitore;
import org.orm.PersistentException;

/**
 * Created by me on 1/24/2016.
 */
public class CatalogoController {

    /*
     * USAGE
     * Fornitore fornitore = new FornitoreBuilder().setNome("ItalTubi").build();
     */
    class FornitoreBuilder
    {
        Fornitore fornitore = DAOFactory.getDAOFactory().getFornitoreDAO().createFornitore();
        FornitoreBuilder setNome(String strNomeFornitore) {this.fornitore.setNome(strNomeFornitore); return this;}

        Fornitore build() {
            try {
                DAOFactory.getDAOFactory().getFornitoreDAO().save(this.fornitore);
            } catch (PersistentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return this.fornitore;
        }
    }

    /*
     * USAGE
     * DescrizionePezzo descrizionePezzo = new DescrizionePezzoBuilder()
     *  .setNome("Tubo acciaio inox")
     *  .setPeso(1.4f)
     *  .setDiametro(0.020f)
     *  .setFornitore(fornitore)
     *  .build();
     */
    class DescrizionePezzoBuilder
    {
        DescrizionePezzo descrizionePezzo = DAOFactory.getDAOFactory().getDescrizionePezzoDAO().createDescrizionePezzo();
        DescrizionePezzoBuilder setNome(String strNomePezzo) {this.descrizionePezzo.setNome(strNomePezzo); return this;}
        DescrizionePezzoBuilder setPeso(float floatPeso) {this.descrizionePezzo.setPeso(floatPeso); return this;}
        DescrizionePezzoBuilder setDiametro(float floatDiametro)  {this.descrizionePezzo.setDiametro(floatDiametro); return this;}
        DescrizionePezzoBuilder setFornitore(Fornitore fornitore)  {this.descrizionePezzo.setFornitore(fornitore); return this;}

        DescrizionePezzo build() {

            try {
                DAOFactory.getDAOFactory().getDescrizionePezzoDAO().save(this.descrizionePezzo);
            } catch (PersistentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return this.descrizionePezzo;
        }
    }

}
