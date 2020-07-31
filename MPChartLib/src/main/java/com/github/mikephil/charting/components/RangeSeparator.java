package com.github.mikephil.charting.components;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

import com.github.mikephil.charting.utils.Utils;

/**
 * The range separator is an additional feature for all Line-, Bar- and
 * ScatterCharts.  It allows the displaying of additional vertical lines along
 * the x-axis to emphasize certain ranges
 *
 * @author Jhon Cruz
 */

public class RangeSeparator extends ComponentBase {

    private float mFrom = Float.NaN;
    private float mTo = Float.NaN;
    private float mHeight = 40f;
    private String mLabel= "";

    /** the width of the limit line */
    private float mLineWidth = 2f;

    /** the color of the limit line */
    private int mLineColor = Color.rgb(237, 91, 91);

    /** the width of the bottom line */
    private float mBottomLineWidth = 2f;

    /** the color of the bottom line */
    private int mBottomLineColor = Color.rgb(237, 91, 91);

    /** the style of the label text */
    private Paint.Style mTextStyle = Paint.Style.FILL_AND_STROKE;

    /** the path effect of this LimitLine that makes dashed lines possible */
    private DashPathEffect mDashPathEffect = null;

    /** the path effect of this bottom that makes dashed lines possible */
    private DashPathEffect mBottomDashPathEffect = null;

    private Drawable mIcon = null;
    /**
     * the offset in pixels this component has on the icon
     */
    private float mIconXOffset = 5f;

    /**
     * the offset in pixels this component has on the icon
     */
    private float mIconYOffset = 5f;

    /**
     * Constructor with limits.
     *
     * @param from - the position (the value) on the  x-axis
     *            (xIndex) where the first line should appear
     * @param to - the position (the value) on the  x-axis
     *            (xIndex) where the second line should appear
     */
    public RangeSeparator(float from, float to) {
        mFrom = from;
        mTo = to;
    }

    /**
     * Constructor with limits.
     *
     * @param from - the position (the value) on the  x-axis
     *            (xIndex) where the first line should appear
     * @param to - the position (the value) on the  x-axis
     *            (xIndex) where the second line should appear
     */
    public RangeSeparator(float from, float to, String label, float height) {
        mFrom = from;
        mTo = to;
        mLabel = label;
        mHeight = height;
    }

    public float getFrom() {
        return mFrom;
    }

    public float getTo() {
        return mTo;
    }

    public void setHeight(float mHeight) {
        this.mHeight = mHeight;
    }

    public float getHeight() {
        return mHeight;
    }

    public void setIcon(Drawable icon) {
        this.mIcon = icon;
    }

    public Drawable getIcon() {
        return mIcon;
    }

    public void setIconXOffset(float mIconXOffset) {
        this.mIconXOffset = mIconXOffset;
    }

    public float getIconXOffset() {
        return mIconXOffset;
    }

    public void setIconYOffset(float mIconYOffset) {
        this.mIconYOffset = mIconYOffset;
    }

    public float getIconYOffset() {
        return mIconYOffset;
    }

    public void setLabel(String mLabel) {
        this.mLabel = mLabel;
    }

    /**
     * Returns the label that is drawn next to the limit line.
     *
     * @return
     */
    public String getLabel() {
        return mLabel;
    }

    /**
     * set the line width of the chart (min = 0.2f, max = 12f); default 2f NOTE:
     * thinner line == better performance, thicker line == worse performance
     *
     * @param width
     */
    public void setLineWidth(float width) {

        if (width < 0.2f)
            width = 0.2f;
        if (width > 12.0f)
            width = 12.0f;
        mLineWidth = Utils.convertDpToPixel(width);
    }

    /**
     * set the line width of the chart (min = 0.2f, max = 12f); default 2f NOTE:
     * thinner line == better performance, thicker line == worse performance
     *
     * @param width
     */
    public void setBottomLineWidth(float width) {

        if (width < 0.2f)
            width = 0.2f;
        if (width > 12.0f)
            width = 12.0f;
        mBottomLineWidth= Utils.convertDpToPixel(width);
    }

    /**
     * returns the width of limit line
     *
     * @return
     */
    public float getLineWidth() {
        return mLineWidth;
    }

    /**
     * returns the width of bottom line
     *
     * @return
     */
    public float getBottomLineWidth() {
        return mBottomLineWidth;
    }

    /**
     * Sets the linecolor for this LimitLine. Make sure to use
     * getResources().getColor(...)
     *
     * @param color
     */
    public void setLineColor(int color) {
        mLineColor = color;
    }

    public void setBottomLineColor(int color) {
        mBottomLineColor = color;
    }

    /**
     * Returns the color that is used for this LimitLine
     *
     * @return
     */
    public int getLineColor() {
        return mLineColor;
    }

    public int getBottomLineColor() {
        return mBottomLineColor;
    }

    /**
     * Enables the line to be drawn in dashed mode, e.g. like this "- - - - - -"
     *
     * @param lineLength the length of the line pieces
     * @param spaceLength the length of space inbetween the pieces
     * @param phase offset, in degrees (normally, use 0)
     */
    public void enableDashedLine(float lineLength, float spaceLength, float phase) {
        mDashPathEffect = new DashPathEffect(new float[] {
                lineLength, spaceLength
        }, phase);
    }

    public void enableBottomDashedLine(float lineLength, float spaceLength, float phase) {
        mBottomDashPathEffect = new DashPathEffect(new float[] {
                lineLength, spaceLength
        }, phase);
    }

    /**
     * Disables the line to be drawn in dashed mode.
     */
    public void disableDashedLine() {
        mDashPathEffect = null;
    }

    public void disableBottomDashedLine() {
        mBottomDashPathEffect= null;
    }

    /**
     * Returns true if the dashed-line effect is enabled, false if not. Default:
     * disabled
     *
     * @return
     */
    public boolean isDashedLineEnabled() {
        return mDashPathEffect == null ? false : true;
    }

    public boolean isBottomDashedLineEnabled() {
        return mBottomDashPathEffect == null ? false : true;
    }

    /**
     * returns the DashPathEffect that is set for this LimitLine
     *
     * @return
     */
    public DashPathEffect getDashPathEffect() {
        return mDashPathEffect;
    }

    public DashPathEffect getBottomDashPathEffect() {
        return mBottomDashPathEffect;
    }

    /**
     * Sets the color of the value-text that is drawn next to the LimitLine.
     * Default: Paint.Style.FILL_AND_STROKE
     *
     * @param style
     */
    public void setTextStyle(Paint.Style style) {
        this.mTextStyle = style;
    }

    /**
     * Returns the color of the value-text that is drawn next to the LimitLine.
     *
     * @return
     */
    public Paint.Style getTextStyle() {
        return mTextStyle;
    }
}
