package management;

import reporting.*;
import java.io.*;
import java.util.*;
import java.util.jar.*;
import java.net.*;

/*
 * ManagmentKlasse fuer Analytiker
 */
public class AnalytikerManagement {

	/*
	 * retourniert alle Reports im System
	 */
	public static java.util.TreeMap<String, String> getReportList() {
		java.util.TreeMap<String, String> ret = new java.util.TreeMap<String, String>();
		try {
			//load package
			Class.forName("reporting.ParamType");
			
			for (Class<?> cls : getClassesForPackage(Package.getPackage("reporting"))) {
				if (cls.getSuperclass() == reporting.Report.class) {
					ret.put(cls.getName(), cls.getAnnotation(reporting.ReportDescription.class).Description());
				}
			}
		}
		catch (java.lang.ClassNotFoundException ex) {
		}
		
		return ret;
	}

	public static Report getReportByName(String name) {
		try {
			Class<?> clazz = Class.forName(name);
			Report report = (Report)clazz.newInstance();
			return report;
		}
		catch(Exception e) {			
		}
		return null;
	}

	/*
	 * executiert Report und retourniert FileName von erstellten Daten
	 */
	public static void execReport(String fileName, String reportName, java.util.TreeMap<String, Object> paramValues) {
		Report rep = getReportByName(reportName);
		try {
			File fout = new File(fileName);
			FileOutputStream fos = new FileOutputStream(fout);
		 
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		 
			rep.exec(bw, paramValues);
		 
			bw.flush();
			bw.close();
		}
		catch (Exception e) {
		}
	}

	/*
	 * executiert Report
	 */
	public static void execReport(javax.servlet.http.HttpServletResponse response, String reportName, java.util.TreeMap<String, Object> paramValues) throws IOException {
		Report rep = getReportByName(reportName);
		rep.exec(response.getWriter(), paramValues, response);
	}

	private static ArrayList<Class<?>> getClassesForPackage(Package pkg) {
	    String pkgname = pkg.getName();
	    ArrayList<Class<?>> classes = new ArrayList<Class<?>>();
	    // Get a File object for the package
	    File directory = null;
	    String fullPath;
	    String relPath = pkgname.replace('.', '/');
	    //System.out.println("ClassDiscovery: Package: " + pkgname + " becomes Path:" + relPath);
	    URL resource = AnalytikerManagement.class.getClassLoader().getResource(relPath);
	    //System.out.println("ClassDiscovery: Resource = " + resource);
	    if (resource == null) {
	        throw new RuntimeException("No resource for " + relPath);
	    }
	    fullPath = resource.getFile();
	    //System.out.println("ClassDiscovery: FullPath = " + resource);

	    try {
	        directory = new File(resource.toURI());
	    } catch (URISyntaxException e) {
	        throw new RuntimeException(pkgname + " (" + resource + ") does not appear to be a valid URL / URI.  Strange, since we got it from the system...", e);
	    } catch (IllegalArgumentException e) {
	        directory = null;
	    }
	    //System.out.println("ClassDiscovery: Directory = " + directory);

	    if (directory != null && directory.exists()) {
	        // Get the list of the files contained in the package
	        String[] files = directory.list();
	        for (int i = 0; i < files.length; i++) {
	            // we are only interested in .class files
	            if (files[i].endsWith(".class")) {
	                // removes the .class extension
	                String className = pkgname + '.' + files[i].substring(0, files[i].length() - 6);
	                //System.out.println("ClassDiscovery: className = " + className);
	                try {
	                    classes.add(Class.forName(className));
	                } 
	                catch (ClassNotFoundException e) {
	                    throw new RuntimeException("ClassNotFoundException loading " + className);
	                }
	            }
	        }
	    }
	    else {
            String jarPath = fullPath.replaceFirst("[.]jar[!].*", ".jar").replaceFirst("file:", "");
            JarFile jarFile = null;         
	        try {
	        	jarFile = new JarFile(jarPath);
	            Enumeration<JarEntry> entries = jarFile.entries();
	            while(entries.hasMoreElements()) {
	                JarEntry entry = entries.nextElement();
	                String entryName = entry.getName();
	                if(entryName.startsWith(relPath) && entryName.length() > (relPath.length() + "/".length())) {
	                    //System.out.println("ClassDiscovery: JarEntry: " + entryName);
	                    String className = entryName.replace('/', '.').replace('\\', '.').replace(".class", "");
	                    //System.out.println("ClassDiscovery: className = " + className);
	                    try {
	                        classes.add(Class.forName(className));
	                    } 
	                    catch (ClassNotFoundException e) {
	                        throw new RuntimeException("ClassNotFoundException loading " + className);
	                    }
	                }
	            }
	        } catch (IOException e) {
	            throw new RuntimeException(pkgname + " (" + directory + ") does not appear to be a valid package", e);
	        }
	        finally {
	        	try {
					jarFile.close();
				} catch (Exception e) {
				}
	        }
	    }
	    return classes;
	}
}
