package org.openmrs.module.ugandaemrfingerprint.page.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.appframework.domain.AppDescriptor;
import org.openmrs.module.appui.UiSessionContext;
import org.openmrs.module.coreapps.helper.BreadcrumbHelper;
import org.openmrs.module.ugandaemrfingerprint.core.FingerPrintConstant;
import org.openmrs.module.ugandaemrfingerprint.remoteserver.FingerPrintGlobalProperties;
import org.openmrs.ui.framework.UiUtils;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Marking a patient as dead
 */
public class FindPatientFingerprintPageController {
    protected final Log log = LogFactory.getLog(this.getClass());

    public void controller(UiSessionContext sessionContext, PageModel model) {
    }

    public void get(PageModel model, @RequestParam("app") AppDescriptor app, UiSessionContext sessionContext,
                    UiUtils ui) {
        FingerPrintGlobalProperties fingerPrintGlobalProperties = new FingerPrintGlobalProperties();
        model.addAttribute("afterSelectedUrl", app.getConfig().get("afterSelectedUrl").getTextValue());
        model.addAttribute("heading", app.getConfig().get("heading").getTextValue());
        model.addAttribute("label", app.getConfig().get("label").getTextValue());
        model.addAttribute("showLastViewedPatients", app.getConfig().get("showLastViewedPatients").getBooleanValue());
        model.put("fingerSocketPrintIpAddress", fingerPrintGlobalProperties.getGlobalProperty(FingerPrintConstant.GP_DEVICE_SOCKET_IP));
        BreadcrumbHelper.addBreadcrumbsIfDefinedInApp(app, model, ui);
    }
}
