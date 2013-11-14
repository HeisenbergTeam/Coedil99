CREATE TABLE Commessa (ID int(11) NOT NULL AUTO_INCREMENT, Priorita int(11), OrdineID int(11), DataCreazione date, PRIMARY KEY (ID)) ENGINE=InnoDB;
CREATE TABLE Distinta (ID int(11) NOT NULL AUTO_INCREMENT, DataInizio date, CommessaID int(11), Revisione int(11) NOT NULL, Modello varchar(255), ElementoStrutturale varchar(255), PRIMARY KEY (ID)) ENGINE=InnoDB;
CREATE TABLE Ordine (ID int(11) NOT NULL AUTO_INCREMENT, DataCreazione date, DestinazioneID int(11) NOT NULL, PRIMARY KEY (ID)) ENGINE=InnoDB;
CREATE TABLE Pezzo (ID int(11) NOT NULL AUTO_INCREMENT, DataArrivo date, Quantita int(11), DescrizionePezzoID int(11) NOT NULL, PRIMARY KEY (ID)) ENGINE=InnoDB;
CREATE TABLE DescrizionePezzo (ID int(11) NOT NULL AUTO_INCREMENT, Nome varchar(255), Fornitore varchar(255), Diametro float NOT NULL, Peso float NOT NULL, PRIMARY KEY (ID)) ENGINE=InnoDB;
CREATE TABLE RigaDistinta (ID int(11) NOT NULL AUTO_INCREMENT, PezzoID int(11) NOT NULL, DistintaID int(11) NOT NULL, LavorazionePezzoID int(11) NOT NULL, Indicazione varchar(255), PRIMARY KEY (ID)) ENGINE=InnoDB;
CREATE TABLE LavorazionePezzo (ID int(11) NOT NULL AUTO_INCREMENT, Descrizione varchar(255), MisuraDiTaglio float NOT NULL, Peso float NOT NULL, SagomaID int(11), PRIMARY KEY (ID)) ENGINE=InnoDB;
CREATE TABLE DescrizionePezzo_LavorazionePezzo (DescrizionePezzoID int(11) NOT NULL, LavorazionePezzoID int(11) NOT NULL, PRIMARY KEY (DescrizionePezzoID, LavorazionePezzoID)) ENGINE=InnoDB;
CREATE TABLE Destinazione (ID int(11) NOT NULL AUTO_INCREMENT, Via varchar(255), PRIMARY KEY (ID)) ENGINE=InnoDB;
CREATE TABLE Sagoma (ID int(11) NOT NULL AUTO_INCREMENT, Img varchar(255), PRIMARY KEY (ID)) ENGINE=InnoDB;
ALTER TABLE RigaDistinta ADD INDEX FKRigaDistin237062 (PezzoID), ADD CONSTRAINT FKRigaDistin237062 FOREIGN KEY (PezzoID) REFERENCES Pezzo (ID);
ALTER TABLE Commessa ADD INDEX FKCommessa136300 (OrdineID), ADD CONSTRAINT FKCommessa136300 FOREIGN KEY (OrdineID) REFERENCES Ordine (ID);
ALTER TABLE Distinta ADD INDEX FKDistinta186384 (CommessaID), ADD CONSTRAINT FKDistinta186384 FOREIGN KEY (CommessaID) REFERENCES Commessa (ID);
ALTER TABLE RigaDistinta ADD INDEX FKRigaDistin310981 (LavorazionePezzoID), ADD CONSTRAINT FKRigaDistin310981 FOREIGN KEY (LavorazionePezzoID) REFERENCES LavorazionePezzo (ID);
ALTER TABLE Pezzo ADD INDEX FKPezzo181172 (DescrizionePezzoID), ADD CONSTRAINT FKPezzo181172 FOREIGN KEY (DescrizionePezzoID) REFERENCES DescrizionePezzo (ID);
ALTER TABLE RigaDistinta ADD INDEX FKRigaDistin722808 (DistintaID), ADD CONSTRAINT FKRigaDistin722808 FOREIGN KEY (DistintaID) REFERENCES Distinta (ID);
ALTER TABLE DescrizionePezzo_LavorazionePezzo ADD INDEX FKDescrizion891930 (DescrizionePezzoID), ADD CONSTRAINT FKDescrizion891930 FOREIGN KEY (DescrizionePezzoID) REFERENCES DescrizionePezzo (ID);
ALTER TABLE DescrizionePezzo_LavorazionePezzo ADD INDEX FKDescrizion185100 (LavorazionePezzoID), ADD CONSTRAINT FKDescrizion185100 FOREIGN KEY (LavorazionePezzoID) REFERENCES LavorazionePezzo (ID);
ALTER TABLE Ordine ADD INDEX FKOrdine400104 (DestinazioneID), ADD CONSTRAINT FKOrdine400104 FOREIGN KEY (DestinazioneID) REFERENCES Destinazione (ID);
ALTER TABLE LavorazionePezzo ADD INDEX FKLavorazion28032 (SagomaID), ADD CONSTRAINT FKLavorazion28032 FOREIGN KEY (SagomaID) REFERENCES Sagoma (ID);
