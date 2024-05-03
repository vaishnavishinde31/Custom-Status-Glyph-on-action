package ext.plxworx;

import java.util.ArrayList;
import java.util.Locale;

import org.json.JSONObject;

import com.ptc.core.components.descriptor.ModelContext;
import com.ptc.core.components.factory.dataUtilities.DefaultDataUtility;
import com.ptc.core.components.rendering.guicomponents.IconComponent;
import com.ptc.core.lwc.server.PersistableAdapter;


import wt.part.WTPart;
import wt.util.WTException;

public class CustomIconDataUtility extends DefaultDataUtility{
	
	
 public Object getDataValue(String componentId,Object datum,ModelContext modelContext) throws WTException{
	Object component=super.getDataValue(componentId,datum,modelContext);
	     Object customAttrvalue = null;
	     if(datum instanceof WTPart)
	     {
	    	WTPart part=(WTPart) datum;
	    	PersistableAdapter obj;
			
				obj = new PersistableAdapter(part, null, Locale.US, null);
				obj.load("customicon");
				customAttrvalue = obj.get("customicon");
	    	  System.out.println("custom value="+customAttrvalue);
	     if(customAttrvalue.equals(true))
	     {
			String img_src = "netmarkets\\images\\approbt.gif";
			IconComponent iconComponent = new IconComponent(img_src);
			ArrayList arrlst = new ArrayList();
			arrlst.add(iconComponent);
			return arrlst;
	     }
	     
	}
	     return component;   
}
 
}
