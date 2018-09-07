package com.und.softwaretool.utility;

import com.und.softwaretool.model.FunctionalReq;
import com.und.softwaretool.model.NonFunctionalReq;

public class CustomRequirementRelationDetail {
	private FunctionalReq functionalReq;
	private FunctionalReq relatedFunctionalReq;
	private NonFunctionalReq relatedNonFunctionalReq;
	public FunctionalReq getFunctionalReq() {
		return functionalReq;
	}
	public void setFunctionalReq(FunctionalReq functionalReq) {
		this.functionalReq = functionalReq;
	}
	public FunctionalReq getRelatedFunctionalReq() {
		return relatedFunctionalReq;
	}
	public void setRelatedFunctionalReq(FunctionalReq relatedFunctionalReq) {
		this.relatedFunctionalReq = relatedFunctionalReq;
	}
	public NonFunctionalReq getRelatedNonFunctionalReq() {
		return relatedNonFunctionalReq;
	}
	public void setRelatedNonFunctionalReq(NonFunctionalReq relatedNonFunctionalReq) {
		this.relatedNonFunctionalReq = relatedNonFunctionalReq;
	}
	@Override
	public String toString() {
		return "RequirementRelationDetail [functionalReq=" + functionalReq
				+ ", relatedFunctionalReq=" + relatedFunctionalReq
				+ ", relatedNonFunctionalReq=" + relatedNonFunctionalReq + "]";
	}
}
