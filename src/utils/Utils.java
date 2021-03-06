package utils;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.xsd.util.XSDResourceFactoryImpl;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * Utility class for J-T-Core.
 */
public abstract class Utils {
    /**
     * Constant for MTpre__
     */
    public final static String PRE_ = "MTpre__";
    
    /**
     * Constant for MTpos__
     */
    public final static String POST_ = "MTpos__";
    
    /**
     * Constant for MT__
     */
    public final static String MT_ = "MT__";
    
    /**
     * Constant for MT__label
     */
    public final static String MT_LABEL = "MT__label";
    
    /**
     * Constant for MT__matchSubtype
     */
    public final static String MT_MATCHSUBTYPE = "MT__matchSubtype";

    // Singleton js engine
    @SuppressWarnings("javadoc")
	public final static ScriptEngine js = new ScriptEngineManager().getEngineByName("nashorn");

    private final static ResourceSetImpl resourceSet = new ResourceSetImpl();

    /**
     * Initializes the resource factories necessary to import and export EMF files. <br>
     * Must absolutely be called once before any imports / exports.
     */
    public static void initialize() {
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xsd", new XSDResourceFactoryImpl());   /*new*/
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xml", new XMLResourceFactoryImpl());	/*new*/
    }

    /**
     * Removes prefix from augmented name and returns resulting string.
     *
     * @param augmentedName Prefix + Name.
     * @param prefix        Prefix from tcore.utils constants.
     * @return Substring with only the name.
     */
    public static String getOriginalName(@NotNull String augmentedName, String prefix) {
        return augmentedName.startsWith(prefix) ? augmentedName.substring(prefix.length()) : augmentedName;
    }

    /**
     * Get Resource Set.
     * 
     * @return
     */
    @Contract(pure = true)
    public static ResourceSetImpl getResourceSet() {
        return resourceSet;
    }
}
