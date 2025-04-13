package interpreter;

import javax.swing.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MeasurementConversion {

    public static void main(String[] args) {

        // Create pop up window that asks for a question

        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final String questionAsked = JOptionPane.showInputDialog(frame, "What is your question");

        // Add the question to the context for analysis

        final ConversionContext question = new ConversionContext(questionAsked);

        final String fromConversion = question.getFromConversion();

        final String toConversion = question.getToConversion();

        final double quantity = question.getQuantity();

        try {

            // Get class based on the from conversion string

            final Class tempClass = Class.forName(fromConversion);

            // Get the constructor dynamically for the conversion string

            final Constructor con = tempClass.getConstructor();

            // Create a new instance of the object you want to convert from

            final Object convertFrom = con.newInstance();

            // Define the method parameters expected by the method that
            // will convert to your chosen unit of measure

            final Class[] methodParams = new Class[]{Double.TYPE};

            // Get the method dynamically that will be needed to convert
            // into your chosen unit of measure

            final Method conversionMethod = tempClass.getMethod(toConversion, methodParams);

            // Define the method parameters that will be passed to the above method

            final Object[] params = new Object[]{quantity};

            // Get the quantity after the conversion

            final String toQuantity = (String) conversionMethod.invoke(convertFrom, params);

            // Print the results

            final String answerToQues = question.getResponse() +
                toQuantity + " " + toConversion;

            JOptionPane.showMessageDialog(null, answerToQues);

            // Closes the frame after OK is clicked

            frame.dispose();

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}