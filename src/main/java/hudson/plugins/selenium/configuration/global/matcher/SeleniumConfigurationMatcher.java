package hudson.plugins.selenium.configuration.global.matcher;

import hudson.DescriptorExtensionList;
import hudson.ExtensionPoint;
import hudson.model.Describable;
import hudson.model.Descriptor;
import hudson.model.Node;
import jenkins.model.Jenkins;

import java.io.Serializable;

public abstract class SeleniumConfigurationMatcher implements ExtensionPoint, Describable<SeleniumConfigurationMatcher>, Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = -8723977886089297294L;

    public abstract boolean match(Node node);

    public static DescriptorExtensionList<SeleniumConfigurationMatcher, MatcherDescriptor> all() {
        return Jenkins.getInstance().getDescriptorList(SeleniumConfigurationMatcher.class);
    }

    public abstract static class MatcherDescriptor extends Descriptor<SeleniumConfigurationMatcher> {

    }

    public MatcherDescriptor getDescriptor() {
        return (MatcherDescriptor) Jenkins.getInstance().getDescriptorOrDie(getClass());
    }

    public String getSummary() {
        return getDescriptor().getDisplayName();
    }

}
