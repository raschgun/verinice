/*******************************************************************************
 * Copyright (c) 2016 Ruth Motza.
 *
 * This program is free software: you can redistribute it and/or 
 * modify it under the terms of the GNU Lesser General Public License 
 * as published by the Free Software Foundation, either version 3 
 * of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,    
 * but WITHOUT ANY WARRANTY; without even the implied warranty 
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. 
 * If not, see <http://www.gnu.org/licenses/>.
 * 
 * Contributors:
 *     Ruth Motza <rm[at]sernet[dot]de> - initial API and implementation
 ******************************************************************************/
package sernet.verinice.rcp.linktable.ui.combo;

import java.util.*;

import org.apache.log4j.Logger;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Composite;

import sernet.verinice.model.common.CnATreeElement;
import sernet.verinice.rcp.linktable.ui.LinkTableColumn;
import sernet.verinice.service.model.IObjectModelService;

/**
 * Provides a combo box for {@link CnATreeElement}
 * 
 * 
 * @see IObjectModelService
 * @author Ruth Motza <rm[at]sernet[dot]de>
 */
public class LinkTableElementComboViewer extends LinkTableComboViewer {

    private static final Logger LOG = Logger.getLogger(LinkTableElementComboViewer.class);

    private boolean isDefault;

    public LinkTableElementComboViewer(LinkTableColumn ltrParent,
            Composite parent) {
        this(null, null, null, ltrParent, parent);

    }

    public LinkTableElementComboViewer(LinkTableComboViewer leftCombo, String relatedID,
            LinkTableOperationType operationType,
            LinkTableColumn ltrParent, Composite parent) {
        this(leftCombo, relatedID, operationType, ltrParent, parent, false);
    }

    public LinkTableElementComboViewer(LinkTableComboViewer leftCombo, String relatedID,
            LinkTableOperationType operationType,
            LinkTableColumn ltrParent, Composite parent, boolean isFirstElement) {
        super(leftCombo, relatedID, operationType, ltrParent, parent);

        if (isFirstElement || isDefault) {
            selectFirstElement(!isDefault);
        }
    }


    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.
     * eclipse.jface.viewers.SelectionChangedEvent)
     */
    @Override
    public LinkTableComboViewer createChild(Composite parent) {

        if (operationType == LinkTableOperationType.PROPERTY) {
            return null;
        } else if (operationType == LinkTableOperationType.RELATION) {
            LinkTableOperationTypeComboViewer opType = new LinkTableOperationTypeComboViewer(
                    this, getCurrentSelection(), operationType,
                    ltrColumn,
                    parent);
            opType.select(LinkTableOperationType.PROPERTY.getOutput());
            opType.getCombo().setEnabled(false);
            opType.selectionChanged(null);
            return opType;

        } else {
            return new LinkTableOperationTypeComboViewer(this, getCurrentSelection(), operationType,
                    ltrColumn,
                    parent);
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.
     * lang.Object)
     */
    @Override
    public Object[] getElements(Object inputElement) {
        IObjectModelService objectService = ltrColumn.getContentService();
        String[] typeIDs;
        if (leftCombo == null || relatedID.isEmpty()) {
            typeIDs = new ArrayList<>(objectService.getAllTypeIDs()).toArray(new String[0]);
        } else {
            switch (operationType) {
            case CHILD:
                typeIDs = objectService.getPossibleChildren(relatedID)
                        .toArray(new String[0]);
                break;
            case GROUP:
                typeIDs = objectService.getPossibleParents(relatedID)
                        .toArray(new String[0]);
                break;
            case RELATION:
                typeIDs = objectService.getPossibleRelationPartners(relatedID)
                        .toArray(new String[0]);
                break;
            case RELATION_OBJECT:
                typeIDs = objectService.getPossibleRelationPartners(relatedID)
                        .toArray(new String[0]);
                break;
            default:
                throw new IllegalArgumentException("not supported type " + operationType);
            }

            if (typeIDs.length == 0) {
                typeIDs = new String[] { operationType.getDefaultMessage() };
                isDefault = true;
            }

        }
        return sortElementsByLabel(typeIDs);
    }

    /*
     * (non-Javadoc)
     * 
     * @see sernet.verinice.rcp.linktable.ui.combo.LTRComboViewer#copy()
     */
    @Override
    public LinkTableComboViewer createCopy(LinkTableComboViewer leftCombo, LinkTableColumn ltrParent,
            Composite newParent) {

        return new LinkTableElementComboViewer(leftCombo, relatedID, operationType, ltrParent,
                newParent, false);
    }


    /*
     * (non-Javadoc)
     * 
     * @see sernet.verinice.rcp.linktable.ui.combo.LTRComboViewer#doSelectionChanged()
     */
    @Override
    protected void doSelectionChanged() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("selection changed to " + getCurrentSelection());
        }
        if (rightCombo != null) {
            rightCombo.relatedID = getCurrentSelection();
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see sernet.verinice.rcp.linktable.ui.combo.LTRComboViewer#getLabelText(java.lang.
     * Object)
     */
    @Override
    protected String getLabelText(Object element) {
        if (element instanceof String) {
            return ltrColumn.getContentService().getLabel((String) element);
        } else {
            return ltrColumn.getContentService().getLabel(element.toString());
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see sernet.verinice.rcp.linktable.ui.combo.LTRComboViewer#refreshCombo()
     */
    @Override
    protected void refreshCombo() {
        this.getCombo().setEnabled(!isDefault);
        super.refreshCombo();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * sernet.verinice.rcp.linktable.ui.combo.LTRComboViewer#select(java.lang.String)
     */
    @Override
    protected void select(String string) {

        ISelection selection = new StructuredSelection(string);
        setSelection(selection);

    }

    /*
     * (non-Javadoc)
     * 
     * @see sernet.verinice.rcp.linktable.ui.combo.
     * LinkTableComboViewer#doGetAllRelationTypes()
     */
    @Override
    protected Set<String> doGetAllRelationTypes() {

        HashSet<String> relationIDs = new HashSet<>(); 
        if (LinkTableOperationType.isRelation(operationType)) {
            relationIDs.addAll(
                    ltrColumn.getContentService().getRelations(relatedID, getCurrentSelection()));
        }
        return relationIDs;
    }

}
