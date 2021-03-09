package com.flightinformation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/*
	ESSE É UMA CLASSE QUE IRA ACOPLAR NO LOGBOOK
*/

//@Embeddable --> Nao se aplica para agregar na classe Logbook pois cria uma linha de custo fico para cada voo
@Entity
public class CustoFixo {
	
	@Id
	private String tailNumber;
	
	@Column(name = "custofixo_hangar")
	private Double hangar;
	
	@Column(name = "custofixo_eec")
	private Double eec;
	
	@Column(name = "custofixo_garantiaMotores")
	private Double garantiaMotores;
	
	@Column(name = "custofixo_garantiaApu")
	private Double garantiaApu;
	
	@Column(name = "custofixo_satComDataLink")
	private Double satComDataLink;
	
	@Column(name = "custofixo_satComPhone")
	private Double satComPhone;
	
	@Column(name = "custofixo_aheadEmbraer")
	private Double aheadEmbraer;
	
	@Column(name = "custofixo_databaseCollins")
	private Double databaseCollins;
	
	@Column(name = "custofixo_eletronicCharts")
	private Double eletronicCharts;
	
	@Column(name = "custofixo_apg")
	private Double apg;
	
	@Column(name = "custofixo_medaire")
	private Double medaire;
	
	@Column(name = "custofixo_flyRight")
	private Double flyRight;
	
	@Column(name = "custofixo_etechPub")
	private Double etechPub;
	
	@Column(name = "custofixo_seguroCasco")
	private Double seguroCasco;
	
	@Column(name = "custofixo_seguroReta")
	private Double seguroReta;
	
	@Column(name = "custofixo_camp")
	private Double camp;
	
	@Column(name = "custofixo_foreFlight")
	private Double foreFlight;
	
	@Column(name = "custofixo_universalFlightPlanning")
	private Double universalFlightPlanning;
	
	@Column(name = "custofixo_aviationDeptTotalWages")
	private Double aviationDeptTotalWages;
	
	@Column(name = "custofixo_manutencaoAnual")
	private Double manutencaoAnual;
	
	//Associacao Aircraft e custo fixo
//	@OneToOne
//	@JoinColumn(name="custofixo_aircraftId")
//	private Aircraft aircraft;
	
	
	
	public Double getManutencaoAnual() {
		return manutencaoAnual;
	}


	public void setManutencaoAnual(Double manutencaoAnual) {
		this.manutencaoAnual = manutencaoAnual;
	}


//	public Aircraft getAircraft() {
//		return aircraft;
//	}
//
//
//	public void setAircraft(Aircraft aircraft) {
//		this.aircraft = aircraft;
//	}


	public CustoFixo(Double hangar, Double eec, Double garantiaMotores, Double garantiaApu, Double satComDataLink,
			Double satComPhone, Double aheadEmbraer, Double databaseCollins, Double eletronicCharts, Double apg,
			Double medaire, Double flyRight, Double etechPub, Double seguroCasco, Double seguroReta, Double camp,
			Double foreFlight, Double universalFlightPlanning, Double aviationDeptTotalWages, Double manutencaoAnual) {
		super();
		this.hangar = hangar;
		this.eec = eec;
		this.garantiaMotores = garantiaMotores;
		this.garantiaApu = garantiaApu;
		this.satComDataLink = satComDataLink;
		this.satComPhone = satComPhone;
		this.aheadEmbraer = aheadEmbraer;
		this.databaseCollins = databaseCollins;
		this.eletronicCharts = eletronicCharts;
		this.apg = apg;
		this.medaire = medaire;
		this.flyRight = flyRight;
		this.etechPub = etechPub;
		this.seguroCasco = seguroCasco;
		this.seguroReta = seguroReta;
		this.camp = camp;
		this.foreFlight = foreFlight;
		this.universalFlightPlanning = universalFlightPlanning;
		this.aviationDeptTotalWages = aviationDeptTotalWages;
		this.manutencaoAnual = manutencaoAnual;
	}
	
	
	public Double getHangar() {
		return hangar;
	}
	public void setHangar(Double hangar) {
		this.hangar = hangar;
	}
	public Double getEec() {
		return eec;
	}
	public void setEec(Double eec) {
		this.eec = eec;
	}
	public Double getGarantiaMotores() {
		return garantiaMotores;
	}
	public void setGarantiaMotores(Double garantiaMotores) {
		this.garantiaMotores = garantiaMotores;
	}
	public Double getGarantiaApu() {
		return garantiaApu;
	}
	public void setGarantiaApu(Double garantiaApu) {
		this.garantiaApu = garantiaApu;
	}
	public Double getSatComDataLink() {
		return satComDataLink;
	}
	public void setSatComDataLink(Double satComDataLink) {
		this.satComDataLink = satComDataLink;
	}
	public Double getSatComPhone() {
		return satComPhone;
	}
	public void setSatComPhone(Double satComPhone) {
		this.satComPhone = satComPhone;
	}
	public Double getAheadEmbraer() {
		return aheadEmbraer;
	}
	public void setAheadEmbraer(Double aheadEmbraer) {
		this.aheadEmbraer = aheadEmbraer;
	}
	public Double getDatabaseCollins() {
		return databaseCollins;
	}
	public void setDatabaseCollins(Double databaseCollins) {
		this.databaseCollins = databaseCollins;
	}
	public Double getEletronicCharts() {
		return eletronicCharts;
	}
	public void setEletronicCharts(Double eletronicCharts) {
		this.eletronicCharts = eletronicCharts;
	}
	public Double getApg() {
		return apg;
	}
	public void setApg(Double apg) {
		this.apg = apg;
	}
	public Double getMedaire() {
		return medaire;
	}
	public void setMedaire(Double medaire) {
		this.medaire = medaire;
	}
	public Double getFlyRight() {
		return flyRight;
	}
	public void setFlyRight(Double flyRight) {
		this.flyRight = flyRight;
	}
	public Double getEtechPub() {
		return etechPub;
	}
	public void setEtechPub(Double etechPub) {
		this.etechPub = etechPub;
	}
	public Double getSeguroCasco() {
		return seguroCasco;
	}
	public void setSeguroCasco(Double seguroCasco) {
		this.seguroCasco = seguroCasco;
	}
	public Double getSeguroReta() {
		return seguroReta;
	}
	public void setSeguroReta(Double seguroReta) {
		this.seguroReta = seguroReta;
	}
	public Double getCamp() {
		return camp;
	}
	public void setCamp(Double camp) {
		this.camp = camp;
	}
	public Double getForeFlight() {
		return foreFlight;
	}
	public void setForeFlight(Double foreFlight) {
		this.foreFlight = foreFlight;
	}
	public Double getUniversalFlightPlanning() {
		return universalFlightPlanning;
	}
	public void setUniversalFlightPlanning(Double universalFlightPlanning) {
		this.universalFlightPlanning = universalFlightPlanning;
	}
	public Double getAviationDeptTotalWages() {
		return aviationDeptTotalWages;
	}
	public void setAviationDeptTotalWages(Double aviationDeptTotalWages) {
		this.aviationDeptTotalWages = aviationDeptTotalWages;
	}
	public Double getManutençãoAnual() {
		return manutencaoAnual;
	}
	public void setManutençãoAnual(Double manutencaoAnual) {
		this.manutencaoAnual = manutencaoAnual;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aheadEmbraer == null) ? 0 : aheadEmbraer.hashCode());
		result = prime * result + ((apg == null) ? 0 : apg.hashCode());
		result = prime * result + ((aviationDeptTotalWages == null) ? 0 : aviationDeptTotalWages.hashCode());
		result = prime * result + ((camp == null) ? 0 : camp.hashCode());
		result = prime * result + ((databaseCollins == null) ? 0 : databaseCollins.hashCode());
		result = prime * result + ((eec == null) ? 0 : eec.hashCode());
		result = prime * result + ((eletronicCharts == null) ? 0 : eletronicCharts.hashCode());
		result = prime * result + ((etechPub == null) ? 0 : etechPub.hashCode());
		result = prime * result + ((flyRight == null) ? 0 : flyRight.hashCode());
		result = prime * result + ((foreFlight == null) ? 0 : foreFlight.hashCode());
		result = prime * result + ((garantiaApu == null) ? 0 : garantiaApu.hashCode());
		result = prime * result + ((garantiaMotores == null) ? 0 : garantiaMotores.hashCode());
		result = prime * result + ((hangar == null) ? 0 : hangar.hashCode());
		result = prime * result + ((manutencaoAnual == null) ? 0 : manutencaoAnual.hashCode());
		result = prime * result + ((medaire == null) ? 0 : medaire.hashCode());
		result = prime * result + ((satComDataLink == null) ? 0 : satComDataLink.hashCode());
		result = prime * result + ((satComPhone == null) ? 0 : satComPhone.hashCode());
		result = prime * result + ((seguroCasco == null) ? 0 : seguroCasco.hashCode());
		result = prime * result + ((seguroReta == null) ? 0 : seguroReta.hashCode());
		result = prime * result + ((universalFlightPlanning == null) ? 0 : universalFlightPlanning.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustoFixo other = (CustoFixo) obj;
		if (aheadEmbraer == null) {
			if (other.aheadEmbraer != null)
				return false;
		} else if (!aheadEmbraer.equals(other.aheadEmbraer))
			return false;
		if (apg == null) {
			if (other.apg != null)
				return false;
		} else if (!apg.equals(other.apg))
			return false;
		if (aviationDeptTotalWages == null) {
			if (other.aviationDeptTotalWages != null)
				return false;
		} else if (!aviationDeptTotalWages.equals(other.aviationDeptTotalWages))
			return false;
		if (camp == null) {
			if (other.camp != null)
				return false;
		} else if (!camp.equals(other.camp))
			return false;
		if (databaseCollins == null) {
			if (other.databaseCollins != null)
				return false;
		} else if (!databaseCollins.equals(other.databaseCollins))
			return false;
		if (eec == null) {
			if (other.eec != null)
				return false;
		} else if (!eec.equals(other.eec))
			return false;
		if (eletronicCharts == null) {
			if (other.eletronicCharts != null)
				return false;
		} else if (!eletronicCharts.equals(other.eletronicCharts))
			return false;
		if (etechPub == null) {
			if (other.etechPub != null)
				return false;
		} else if (!etechPub.equals(other.etechPub))
			return false;
		if (flyRight == null) {
			if (other.flyRight != null)
				return false;
		} else if (!flyRight.equals(other.flyRight))
			return false;
		if (foreFlight == null) {
			if (other.foreFlight != null)
				return false;
		} else if (!foreFlight.equals(other.foreFlight))
			return false;
		if (garantiaApu == null) {
			if (other.garantiaApu != null)
				return false;
		} else if (!garantiaApu.equals(other.garantiaApu))
			return false;
		if (garantiaMotores == null) {
			if (other.garantiaMotores != null)
				return false;
		} else if (!garantiaMotores.equals(other.garantiaMotores))
			return false;
		if (hangar == null) {
			if (other.hangar != null)
				return false;
		} else if (!hangar.equals(other.hangar))
			return false;
		if (manutencaoAnual == null) {
			if (other.manutencaoAnual != null)
				return false;
		} else if (!manutencaoAnual.equals(other.manutencaoAnual))
			return false;
		if (medaire == null) {
			if (other.medaire != null)
				return false;
		} else if (!medaire.equals(other.medaire))
			return false;
		if (satComDataLink == null) {
			if (other.satComDataLink != null)
				return false;
		} else if (!satComDataLink.equals(other.satComDataLink))
			return false;
		if (satComPhone == null) {
			if (other.satComPhone != null)
				return false;
		} else if (!satComPhone.equals(other.satComPhone))
			return false;
		if (seguroCasco == null) {
			if (other.seguroCasco != null)
				return false;
		} else if (!seguroCasco.equals(other.seguroCasco))
			return false;
		if (seguroReta == null) {
			if (other.seguroReta != null)
				return false;
		} else if (!seguroReta.equals(other.seguroReta))
			return false;
		if (universalFlightPlanning == null) {
			if (other.universalFlightPlanning != null)
				return false;
		} else if (!universalFlightPlanning.equals(other.universalFlightPlanning))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CustoFixo [hangar=" + hangar + ", eec=" + eec + ", garantiaMotores=" + garantiaMotores
				+ ", garantiaApu=" + garantiaApu + ", satComDataLink=" + satComDataLink + ", satComPhone=" + satComPhone
				+ ", aheadEmbraer=" + aheadEmbraer + ", databaseCollins=" + databaseCollins + ", eletronicCharts="
				+ eletronicCharts + ", apg=" + apg + ", medaire=" + medaire + ", flyRight=" + flyRight + ", etechPub="
				+ etechPub + ", seguroCasco=" + seguroCasco + ", seguroReta=" + seguroReta + ", camp=" + camp
				+ ", foreFlight=" + foreFlight + ", universalFlightPlanning=" + universalFlightPlanning
				+ ", aviationDeptTotalWages=" + aviationDeptTotalWages + ", manutencaoAnual=" + manutencaoAnual + "]";
	}
	
	
	

}
