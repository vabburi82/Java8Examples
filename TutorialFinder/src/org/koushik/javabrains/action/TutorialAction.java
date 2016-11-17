package org.koushik.javabrains.action;

public class TutorialAction {
private String language;
private String bestTutorialSite ;

public String getBestTutorialSite() {
	return bestTutorialSite;
	
}

public void setBestTutorialSite(String bestTutorialSite) {
	this.bestTutorialSite = bestTutorialSite;
}
public String getTutorial() {
	
//TutorialFinderService tutorialFinderService = new TutorialFinderService();
//System.out.println(getLanguage());
//setBestTutorialSite(tutorialFinderService.getBestTutorialSite(getLanguage()));
	System.out.println("getTutorial() method called");
return "success";
}
public String addTutorial() {
	
//TutorialFinderService tutorialFinderService = new TutorialFinderService();
//System.out.println(getLanguage());
//setBestTutorialSite(tutorialFinderService.getBestTutorialSite(getLanguage()));
	System.out.println("addTutorial() method called");
	return "success";
	
}

public String getLanguage() {
	return language;
}

public void setLanguage(String language) {
	this.language = language;
}
}
