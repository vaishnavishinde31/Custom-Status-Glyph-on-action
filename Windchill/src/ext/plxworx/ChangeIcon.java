
package ext.plxworx;
 

import java.util.Iterator;
import java.util.List;

import com.ptc.jca.mvc.builders.DefaultInfoComponentBuilder;
import com.ptc.jca.mvc.components.AbstractInfoComponentBuilder;
import com.ptc.mvc.components.ComponentBuilder;
import com.ptc.mvc.components.ComponentConfig;
import com.ptc.mvc.components.ComponentParams;
import com.ptc.mvc.components.InfoComponentConfigFactory;
import com.ptc.mvc.components.InfoConfig;
import com.ptc.mvc.components.PropertyConfig;
import com.ptc.mvc.components.TypeBased;

import wt.fc.WTObject;
import wt.part.WTPart;
import wt.util.WTException;

 

@TypeBased({"com.ptc.ElectricalPart"})
public class ChangeIcon  extends DefaultInfoComponentBuilder {
	
       @Override
     public InfoConfig buildInfoConfig(ComponentParams var1) throws WTException {
       System.out.println("Info page config begin");
         InfoComponentConfigFactory factory = this.getComponentConfigFactory();
         InfoConfig infoConfig = factory.newInfoConfig();
         List var4 = factory.getStandardStatusConfigs();
         
         PropertyConfig statusFamilySecurity = factory.newPropertyConfig ("netmarkets\\images\\approbt.gif");  
         statusFamilySecurity.setStatusGlyph(true);
         statusFamilySecurity.setDataUtilityId("customdatautility");
         var4.add(statusFamilySecurity);
        
         infoConfig.setNavBarName("third_level_nav_part");
         infoConfig.setHelpContext("part.view");
         infoConfig.setTabSet("partInfoPageTabSet");
         
        // statusFamilySecurity.setInfoPageLink(true);
         infoConfig.addComponent(statusFamilySecurity); 
         System.out.println("Info page config end");
         return infoConfig;
       
  }
           
}