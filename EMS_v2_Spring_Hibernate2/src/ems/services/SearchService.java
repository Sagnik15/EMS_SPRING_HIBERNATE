package ems.services;

import ems.dao.SearchDao;

import ems.beans.MedicineBean;

public class SearchService {

	SearchDao searchdao;
	public SearchDao getSearchdao() {
		return searchdao;
	}
	public void setSearchdao(SearchDao searchdao) {
		this.searchdao = searchdao;
	}
	public String addMed(MedicineBean mb) {


		String result = searchdao.addMed(mb);
		return result;
	}

}
