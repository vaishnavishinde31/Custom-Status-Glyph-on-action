

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
        InfoComponentConfigFactory var2 = this.getComponentConfigFactory();
        InfoConfig var3 = var2.newInfoConfig();
        List var4 = var2.getStandardStatusConfigs();
        PropertyConfig var5 = var2.newPropertyConfig("netmarkets\\images\\approbt.gif");
        var5.setStatusGlyph(true);
        var5.setDataUtilityId("customdatautility");
        var4.add(var5);
        Iterator var6 = var4.iterator();

        while(var6.hasNext()) {
           ComponentConfig var7 = (ComponentConfig)var6.next();
           var3.addComponent(var7);
        }

        var3.setNavBarName("third_level_nav_part");
        var3.setHelpContext("part.view");
        var3.setTabSet("partInfoPageTabSet");
        return var3;
     }
	   
}