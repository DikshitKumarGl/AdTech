package com.adtech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adtech.model.CampaignSite;

public interface CampaigningRepository extends JpaRepository<CampaignSite, Integer> {

}
