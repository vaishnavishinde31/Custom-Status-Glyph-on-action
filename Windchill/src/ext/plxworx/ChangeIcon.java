

package ext.plxworx;

import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.List;
import com.ptc.jca.mvc.builders.DefaultInfoComponentBuilder;
import com.ptc.jca.mvc.components.AbstractInfoComponentBuilder;
import com.ptc.mvc.components.AbstractInfoConfigBuilder;
import com.ptc.mvc.components.ComponentBuilder;
import com.ptc.mvc.components.ComponentBuilderType;
import com.ptc.mvc.components.ComponentConfig;
import com.ptc.mvc.components.ComponentDataBuilder;
import com.ptc.mvc.components.ComponentParams;
import com.ptc.mvc.components.InfoComponentConfigFactory;
import com.ptc.mvc.components.InfoConfig;
import com.ptc.mvc.components.PropertyConfig;
import com.ptc.mvc.components.TypeBased;
import wt.fc.WTObject;
import wt.part.WTPart;
import wt.util.WTException;

@ComponentBuilder({"infoPage"})
@TypeBased({"com.ptc.ElectricalPart"})
public class ChangeIcon extends DefaultInfoComponentBuilder {
	
	     @Override
    public InfoConfig buildInfoConfig(ComponentParams var1) throws WTException {
      System.out.println("Info page config begin");
        InfoComponentConfigFactory factory = this.getComponentConfigFactory();
        InfoConfig infoconfig = factory.newInfoConfig();
        List list = factory.getStandardStatusConfigs();
        PropertyConfig propconfig = factory.newPropertyConfig("netmarkets\\images\\approbt.gif");
        propconfig.setStatusGlyph(true);
        propconfig.setDataUtilityId("customdatautility");
        list.add(propconfig);
        Iterator iter = list.iterator();

        while(iter.hasNext()) {
           ComponentConfig componentconfig = (ComponentConfig)iter.next();
           infoconfig.addComponent(componentconfig);
        }

        infoconfig.setNavBarName("third_level_nav_part");
        infoconfig.setHelpContext("part.view");
        infoconfig.setTabSet("partInfoPageTabSet");
        return infoconfig;
     }
	   
}