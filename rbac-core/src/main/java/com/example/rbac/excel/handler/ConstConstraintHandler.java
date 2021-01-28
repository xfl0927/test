package com.example.rbac.excel.handler;

import com.alibaba.excel.write.handler.SheetWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteWorkbookHolder;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.util.CellRangeAddressList;

/**
 * 给excel单元格设置下拉框
 *
 * @author Jack
 * @date 2020/04/25
 */
public class ConstConstraintHandler implements SheetWriteHandler {

    private String[] constraint;
    private int firstRow;
    private int lastRow;
    private int firstCol;
    private int lastCol;

    public ConstConstraintHandler(String[] constraint,
                                  int firstRow, int lastRow,
                                  int firstCol, int lastCol) {
        this.constraint = constraint;
        this.firstRow = firstRow;
        this.lastRow = lastRow;
        this.firstCol = firstCol;
        this.lastCol = lastCol;
    }

    @Override
    public void beforeSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {

    }

    @Override
    public void afterSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {
        CellRangeAddressList cellRangeAddressList = new CellRangeAddressList(firstRow, lastRow, firstCol, lastCol);
        DataValidationHelper helper = writeSheetHolder.getSheet().getDataValidationHelper();
        DataValidationConstraint validationConstraint = helper.createExplicitListConstraint(constraint);
        DataValidation dataValidation = helper.createValidation(validationConstraint, cellRangeAddressList);
        writeSheetHolder.getSheet().addValidationData(dataValidation);
    }

}


