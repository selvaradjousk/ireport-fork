/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TableDesignerPanel.java
 *
 * Created on 12-mar-2010, 16.14.33
 */

package com.jaspersoft.ireport.components.table;

import com.jaspersoft.ireport.designer.AbstractReportObjectScene;
import com.jaspersoft.ireport.designer.GenericDesignerPanel;
import com.jaspersoft.ireport.designer.dnd.DesignerDropTarget;
import com.jaspersoft.ireport.designer.ruler.RulerPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.Icon;
import javax.swing.JComponent;
import net.sf.jasperreports.components.table.StandardTable;
import net.sf.jasperreports.engine.design.JRDesignComponentElement;
import net.sf.jasperreports.engine.design.JRDesignDataset;
import net.sf.jasperreports.engine.design.JRDesignElement;
import net.sf.jasperreports.engine.design.JasperDesign;
import org.openide.explorer.ExplorerManager;

/**
 *
 * @author gtoffoli
 */
public class TableDesignerPanel extends javax.swing.JPanel implements GenericDesignerPanel {

    protected JRDesignComponentElement componentElement = null;
    protected StandardTable table = null;

    protected JasperDesign jasperDesign = null;
    protected TableObjectScene scene = null;
    protected JComponent myView = null;
    protected RulerPanel hRuler = null;
    protected RulerPanel vRuler = null;

    /** Creates new form TableDesignerPanel */
    public TableDesignerPanel(JRDesignElement componentElement, JasperDesign jasperdesign) {
        initComponents();
        this.componentElement = (JRDesignComponentElement)componentElement;
        this.table = (StandardTable) this.componentElement.getComponent();
        this.jasperDesign = jasperdesign;
        scene = new TableObjectScene(jasperdesign, this.componentElement);

        myView = scene.getJComponent();

        jScrollPaneMainReport.setViewportView(myView);

        hRuler = new RulerPanel(scene);
        myView.addMouseMotionListener(hRuler);
        hRuler.addGuideLineChangedListener(scene);
        jPanel1.add(hRuler, BorderLayout.CENTER);

        vRuler = new RulerPanel(scene);
        vRuler.setVertical(true);
        myView.addMouseMotionListener(vRuler);
        vRuler.addGuideLineChangedListener(scene);
        jPanel2.add(vRuler, BorderLayout.CENTER);
        myView.setDropTarget(new DesignerDropTarget(scene)); // FIXME Probably this drop target is not ok...

        addPropertyChangeListener(new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals("ancestor"))
                {
                    if (getParent() == null) return;
                    else
                    {
                        // find the explorer manager...
                        Component c = getParent();
                        while (c != null)
                        {
                            if (c instanceof ExplorerManager.Provider)
                            {
                                ((ExplorerManager.Provider)c).getExplorerManager().removePropertyChangeListener(scene);
                                ((ExplorerManager.Provider)c).getExplorerManager().addPropertyChangeListener(scene); // FIXME: we should use a Weak property change listener...
                                return;
                            }
                            c = c.getParent();
                        }
                    }
                }
            }
        });
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPaneMainReport = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setMinimumSize(new java.awt.Dimension(100, 20));
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jScrollPaneMainReport.setBorder(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setMinimumSize(new java.awt.Dimension(20, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(20, 0));
        jPanel2.setLayout(new java.awt.BorderLayout());

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, 0)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .add(jScrollPaneMainReport, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, 0)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .add(jScrollPaneMainReport, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void setJasperDesign(JasperDesign jd) {
        this.jasperDesign = jd;
    }

    public AbstractReportObjectScene getScene() {
        return scene;
    }

    public JRDesignElement getElement() {
        return componentElement;
    }

    public JComponent getComponent() {
        return this;
    }

    public String getLabel() {
        return "Table {0}";
    }

    public Icon getIcon() {
        return new javax.swing.ImageIcon(getClass().getResource("/com/jaspersoft/ireport/components/table/table-16.png"));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPaneMainReport;
    // End of variables declaration//GEN-END:variables

    public JRDesignDataset getElementDataset(JRDesignElement element) {

        if (getScene().findWidget(element) != null)
        {
            if (table.getDatasetRun() != null && table.getDatasetRun().getDatasetName() != null)
            {
                return (JRDesignDataset) jasperDesign.getDatasetMap().get(table.getDatasetRun().getDatasetName());
            }
        }

        return null;


    }

}
