package ext.plxworx;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ptc.core.components.beans.ObjectBean;
import com.ptc.core.components.forms.DefaultObjectFormProcessor;
import com.ptc.core.components.forms.FormResult;
import com.ptc.core.components.rendering.guicomponents.IconComponent;
import com.ptc.core.lwc.server.PersistableAdapter;
import com.ptc.core.meta.common.OperationIdentifier;
import com.ptc.core.meta.common.OperationIdentifierConstants;
import com.ptc.netmarkets.util.beans.NmCommandBean;


import wt.fc.Persistable;
import wt.fc.PersistenceServerHelper;
import wt.iba.value.AttributeContainer;
import wt.iba.value.IBAHolder;
import wt.iba.value.service.IBAValueDBService;
import wt.part.WTPart;
import wt.session.SessionHelper;
import wt.util.WTException;

public class StatusGlyph extends DefaultObjectFormProcessor {

    @Override
    public FormResult doOperation(NmCommandBean nmCommandBean, List<ObjectBean> list) throws WTException {
        WTPart part = (WTPart) nmCommandBean.getPageOid().getRefObject();
        System.out.println("parent part:-" + part.getNumber());

        findPrtNo(part);

        FormResult formResult = super.doOperation(nmCommandBean, list);
        return formResult;
    }

    private void findPrtNo(WTPart part) throws WTException {
        PersistableAdapter persistableAdapter = new PersistableAdapter(part, null, SessionHelper.getLocale(), OperationIdentifier
                .newOperationIdentifier(OperationIdentifierConstants.UPDATE));
        persistableAdapter.load("customicon");
        System.out.println("custom attribute value is loaded.");
        Boolean existingValue = (Boolean) persistableAdapter.get("customicon");

        // Define flag to determine if the value should be updated
        boolean flag = false;

        // Define updated value
        Boolean updatedValue = null;

        // Check the existing value and set the updated value accordingly
        if (existingValue != null) {
            if (existingValue) {
                updatedValue = false; 
               System.out.println(" If existing value is true, set to false");
                flag = true;
            } else {
                updatedValue = true; 
                System.out.println("If existing value is false, set to true");
                flag = true;
            }
        } else {
            
            System.out.println("Existing value is null.");
        }

        // If the flag is true, update the value
        if (flag) {
            persistableAdapter.set("customicon", updatedValue);
            Persistable persistable = persistableAdapter.apply();
            PersistenceServerHelper.manager.update(persistable);
            AttributeContainer attributeContainer = new IBAValueDBService().updateAttributeContainer((IBAHolder) persistable, persistableAdapter, null, null);
            ((IBAHolder) persistable).setAttributeContainer(attributeContainer);
            System.out.println("Attribute Values updated Successfully");
        } else {
            System.out.println("No update needed.");
        }
    }
}

	
    

