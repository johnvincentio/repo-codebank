package demo.activetree.print.component;

import demo.activetree.print.PrintFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import com.activetree.print.PageNoPainter;
import com.activetree.print.AtComponentPrinter;

public class SwingFormPrintDemo extends PrintFrame {
  private Component form;

  public SwingFormPrintDemo() {
    frame.setTitle("Smart JPrint - Printing A Swing Form");
    form = new SwingForm();
    setPrintableComponent(form);
    frame.setSize(new Dimension(480, 600));
    frame.setResizable(false);
  }

  public void actionPerformed(ActionEvent evt) {
    AtComponentPrinter printer = new AtComponentPrinter();

    if (evt.getActionCommand().equals("Print")) {
      printer.print(form, PageNoPainter.LOWER_CENTER);
    }else if (evt.getActionCommand().equals("Generate PDF")) {
      super.printAsPdf(form, pdfPrinter);
    }else if (evt.getActionCommand().equals("Preview")) {
      printer.preview(form, PageNoPainter.LOWER_CENTER, true, frame);
    }
  }

  public static void main(String[] args) {
    com.activetree.utils.AtLAFUtil.setWindowsLookAndFeel();
    if (args != null && args.length >= 1) {
      com.activetree.common.SmartJPrint.setLicenseKey(args[0]);
    }
    else {
      System.out.println("Usage: java " + SwingFormPrintDemo.class.getName() + " licenseKey");
      System.exit(0);
    }

    SwingFormPrintDemo demo = new SwingFormPrintDemo();
    demo.postInit();
    demo.setVisible(true);
  }
}

class ItemContainer extends JPanel {
  protected Insets insets = new Insets(5, 5, 5, 5);
  protected JPanel messagePane;
  protected IconPane headerPane;
  protected IconPane footerPane;
  private ImageIcon headerIcon = new ImageIcon(getClass().getResource("/demo/activetree/image/header_image.gif"));
  private ImageIcon footerIcon = new ImageIcon(getClass().getResource("/demo/activetree/image/footer_image.gif"));

  public ItemContainer() {
    setupContentPane();
  }

  protected void setupContentPane() {
    setLayout(new BorderLayout());
    setBackground(SystemColor.white);
    headerPane = new IconPane(headerIcon);
    footerPane = new IconPane(footerIcon);
    messagePane = new JPanel(new GridBagLayout());
    messagePane.setBackground(SystemColor.white);
    //
    add(headerPane, BorderLayout.NORTH);
    add(messagePane, BorderLayout.CENTER);
    add(footerPane, BorderLayout.SOUTH);
  }

  int gridy = 0;
  public void addItem(ItemPane anItem) {
    messagePane.add(anItem, new GridBagConstraints(0, gridy++, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, new Insets(5, 0, 0, 5), 0, 0));
    messagePane.revalidate();
  }

  public Insets getInsets() {
    return insets;
  }
}

class ItemPane extends JPanel {
  protected Insets insets = new Insets(0, 0, 5, 0);
  protected Font font = new Font("Arial", Font.BOLD, 12);
  protected CheckBoxPane cbPane = new CheckBoxPane(false, false);
  protected TimeCombo timeCombo;
  protected JTextArea text;
  protected JPanel titlePane;

  protected String label;
  protected String title;

  public ItemPane(String title, String label) {
    this.label = label;
    this.title = title;
    setupContentPane();
  }

  protected void setupContentPane() {
    setLayout(new BorderLayout(0, 0));
    setBackground(SystemColor.white);
    setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, SystemColor.BLACK));

    JPanel top = new JPanel(new GridBagLayout());
    top.setBackground(SystemColor.white);
    text = new JTextArea(label);
    text.setFont(new Font("Times New Roman", Font.PLAIN, 12));
    text.setEditable(false);
    timeCombo = new TimeCombo(dd, mm, yyyy);
    if (title != null) {
      titlePane = new JPanel(new BorderLayout());
      JLabel titleLabel = new JLabel(title);
      titleLabel.setFont(font);
      titlePane.add(titleLabel, BorderLayout.CENTER);
      titlePane.setBackground(SystemColor.white);
      titleLabel.setForeground(SystemColor.BLUE.darker().darker());
    }

    top.add(cbPane, new GridBagConstraints(0, 0, 1, 1, 0, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, new Insets(5, 0, 0, 5), 0, 0));
    top.add(text, new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, new Insets(5, 0, 0, 5), 0, 0));
    top.add(timeCombo, new GridBagConstraints(2, 0, 1, 1, 0, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, new Insets(5, 0, 0, 0), 0, 0));

    //
    if (titlePane != null) {
      add(titlePane, BorderLayout.NORTH);
    }
    add(top, BorderLayout.CENTER);
  }

  public Insets getInsets() {
    return insets;
  }

  //populate some sample dd/mm/yyyy data
  String[] dd;
  String[] mm;
  String[] yyyy;
  {
    //dd
    dd = new String[31];
    for (int i=0; i < 31; i++) {
      dd[i] = String.valueOf(i+1);
    }
    //mm
    mm = new String[12];
    for (int i=0; i < 12; i++ ) {
      mm[i] = String.valueOf(i+1);
    }
    //yyyy
    yyyy = new String[2010-1990];
    int year = 1990;
    for (int i=0; i < 20; i++) {
      yyyy[i] = String.valueOf(year++);
    }
  }
}

class CheckBoxPane extends JPanel {
  public static int YES = 1;
  public static int NO = 2;
  public static int NONE = 3;

  protected JCheckBox yesCb = new JCheckBox();
  protected JCheckBox noCb = new JCheckBox();
  private ButtonGroup group = new ButtonGroup();

  public CheckBoxPane(boolean yesSelected, boolean noSelected) {
    yesCb.setSelected(yesSelected);
    noCb.setSelected(noSelected);
    yesCb.setBackground(SystemColor.white);
    noCb.setBackground(SystemColor.white);
    group.add(yesCb);
    group.add(noCb);


    setupContentPane();
  }

  protected void setupContentPane() {
    setBackground(SystemColor.white);
    setLayout(new GridBagLayout());
    add(yesCb, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 0, 0));
    add(noCb, new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
  }

  public int getSelection() {
    ButtonModel m = group.getSelection();
    if (m == yesCb.getModel()) {
      return YES;
    }else if (m == noCb.getModel()) {
      return NO;
    }
    return NONE;
  }
}

class TimeCombo extends JPanel {
  protected JComboBox ddCombo;
  protected JComboBox mmCombo;
  protected JComboBox yyyyCombo;

  public TimeCombo(String[] dd, String mm[], String yyyy[]) {
    ddCombo = new JComboBox(dd);
    ddCombo.setBackground(SystemColor.white);
    mmCombo = new JComboBox(mm);
    mmCombo.setBackground(SystemColor.white);
    yyyyCombo = new JComboBox(yyyy);
    yyyyCombo.setBackground(SystemColor.white);

    //default selection
    ddCombo.setSelectedIndex(0);
    mmCombo.setSelectedIndex(0);
    yyyyCombo.setSelectedIndex(0);

    //
    setupContentPane();
  }

  protected void setupContentPane() {
    setBackground(SystemColor.white);
    setLayout(new GridBagLayout());
    add(ddCombo, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 0, 0));
    add(mmCombo, new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 0, 0));
    add(yyyyCombo, new GridBagConstraints(2, 0, 1, 1, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
  }

  public String getDD() {
    return (String) ddCombo.getSelectedItem();
  }

  public String getMM() {
    return (String) mmCombo.getSelectedItem();
  }

  public String getYYYY() {
    return (String)yyyyCombo.getSelectedItem();
  }
}

class IconPane extends JPanel {
  Dimension prefSize = new Dimension();
  protected ImageIcon icon;

  public IconPane(ImageIcon icon)  {
    this.icon = icon;
    setBackground(SystemColor.white);
    prefSize.width = icon.getIconWidth();
    prefSize.height = icon.getIconHeight();
    setMinimumSize(prefSize);
    setPreferredSize(prefSize);
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    //draw the icon
    Insets insets = getInsets();
    int iconx = insets.left;
    int icony = insets.top;
    if (icon != null) {
      g.drawImage(icon.getImage(), iconx, icony, prefSize.width, prefSize.height, this);
    }
  }
}

class Messages {
  public static final String[] messages =
    {
    "I can unserstand when someone speaks\nvery slowly to me and articulates carefully\nwith long pauses for me to assimilate meaning.",
    "I can unserstand simple directions about\nhow to get from X to Y, on foot or by\npublic transport.",
    "I can understand questions and instructions\naddressed carefully and slowly to me\nand follow short, simple directions.",
    "I can understand numbers, prices and times",
    "I can understand information about people\n(place pr residence, age etc.) in\nnewspapers.",
    "I can locate a concert or a film on calendars\nof public events or posters and identify\nwhere it takes place and at what time\nit starts.",
    "I can understand a questionnaire (entry permit\nform, hotel registration form) well enough\nto give the most important information\nabout myself (name, surname, date of birth,\nnationality).",
    "I can understand words and phrases on signs \nencountered in everyday life (for instance\n \"station\", \"car park\", \"no parking\",\n\"no smoking\", \"keep left\").",
    "I can understand the most important orders in \na computer program such as \"PRINT\", \n\"COPY\" etc.",
    "I can understand short simple messages on \npostcards, for example holiday greetings.",
    "In everyday situations I can understand simple\nmessages written by friends or colleagues,\n for example \"back at 4 o'clock\".",
    "I can introduce somebody and use basic greeting\nand leave-taking expression.",
    "I can ask and answer simple questions, initiate\nand respond to simple statemenets in areas of\n immediate need or on very familiar topics.",
    "I can make myself understood in a simple way\n but I am dependent on my partner being \nprepared to repeat more slowly and repharase \nwhat I say and to help me to say what \nI want.",
    "I can make simple purchases where pointing or \nother gestures can support what I say.",
    "I can handle numbers, quantities, cost and time.",
    "I can ask people for things and give people things.",
    "I can ask people questions about where they live, \npeople they know, things they have etc. and \nanswer such questions addressed to me provided \nthet are articulated slowly and clearly.",
    "I can indicate time by such phrases as \"next \nweek\", \"last Friday\", \"in November\", \n\"three o'clock\".",
    "I can give personal information (address, \ntelephone number, nationality, age, family, and \nhobbies).",
    "I can descrive where I live.",
    "I can say when do not understand.",
    "I can very simply ask somebody to repeat \nwhat said.",
    "I can fill in a questionnaire with my personal \ndetails (job, age, address, hobbies).",
    "I can write a greeting card, for instance a \nbirthday card.",
    "I can write a simple postcard (for example with \nholiday greetings).",
    "I can write a note to tell somebody where \nI am or where we are to meet.",
    "I can write sentences and simple phrases about \nmyself, for example where I live and what I do."
    };
}

class SwingForm extends JPanel {
  protected Insets insets = new Insets(5, 5, 5, 5);
  public SwingForm() {
    setLayout(new GridBagLayout());
    setBackground(SystemColor.white);

    Component header = createHeader();

    Component itemContainer1 = createSampleItemContainer();
    Component itemContainer2 = createSampleItemContainer();
    Component itemContainer3 = createSampleItemContainer();
    Component itemContainer4 = createSampleItemContainer();
    Component itemContainer5 = createSampleItemContainer();
    Component itemContainer6 = createSampleItemContainer();
    JTabbedPane tab = new JTabbedPane();
    tab.addTab("Level A1", itemContainer1);
    tab.addTab("Level A2", itemContainer2);
    tab.addTab("Level B1", itemContainer3);
    tab.addTab("Level B2", itemContainer4);
    tab.addTab("Level C1", itemContainer5);
    tab.addTab("Level C2", itemContainer6);
    //
    add(header, new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, new Insets(5, 0, 0, 5), 0, 0));
    add(tab, new GridBagConstraints(0, 1, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, new Insets(5, 0, 0, 5), 0, 0));
  }

  public Insets getInsets() {
    return insets;
  }

  private Component createHeader() {
    String message
      = "Work through the checklist to identify what you can already do and what you \n" +
      "want to be able to do by the end of your course. Use the first column on the left\n" +
      "of the screen to record your priorities. Use the second column at the different points\n" +
      "during your course to update what you can do. Select the date you hope to\n" +
      "achieve your aim or show when you were able to achieve it.";
    JPanel header = new JPanel(new BorderLayout(0, 5)) {
      Insets headerInsets = new Insets(5, 5, 5, 5);
      public Insets getInsets() {
        return headerInsets;
      }
    };
    header.setBackground(SystemColor.white);
    JLabel label = new JLabel("My Current Language Learning Priorities");
    label.setFont(new Font("Arial", Font.BOLD, 20));
    label.setForeground(SystemColor.BLUE.darker().darker());
    JTextArea textArea = new JTextArea(message);
    textArea.setFont(new Font("Times New Roman", Font.PLAIN, 12));
    textArea.setBackground(SystemColor.white);
    textArea.setEditable(false);
    header.add(label, BorderLayout.NORTH);
    header.add(textArea, BorderLayout.CENTER);
    return header;
  }

  private Component createSampleItemContainer() {
    //populate the data pane
    ItemContainer itemContainer = new ItemContainer();

    ItemPane anItem = new ItemPane("Listening", Messages.messages[0]);
    itemContainer.addItem(anItem);
    anItem = new ItemPane(null, Messages.messages[1]);
    itemContainer.addItem(anItem);
    anItem = new ItemPane(null, Messages.messages[2]);
    itemContainer.addItem(anItem);
    anItem = new ItemPane(null, Messages.messages[3]);
    itemContainer.addItem(anItem);
    anItem = new ItemPane("Reading", Messages.messages[4]);
    itemContainer.addItem(anItem);
    anItem = new ItemPane(null, Messages.messages[5]);
    itemContainer.addItem(anItem);
    anItem = new ItemPane(null, Messages.messages[6]);
    itemContainer.addItem(anItem);
    anItem = new ItemPane(null, Messages.messages[7]);
    itemContainer.addItem(anItem);
    anItem = new ItemPane(null, Messages.messages[8]);
    itemContainer.addItem(anItem);
    anItem = new ItemPane(null, Messages.messages[9]);
    itemContainer.addItem(anItem);
    anItem = new ItemPane(null, Messages.messages[10]);
    itemContainer.addItem(anItem);

    anItem = new ItemPane("Spoken Interaction", Messages.messages[11]);
    itemContainer.addItem(anItem);
    anItem = new ItemPane(null, Messages.messages[12]);
    itemContainer.addItem(anItem);
    anItem = new ItemPane(null, Messages.messages[13]);
    itemContainer.addItem(anItem);
    anItem = new ItemPane(null, Messages.messages[14]);
    itemContainer.addItem(anItem);
    anItem = new ItemPane(null, Messages.messages[15]);
    itemContainer.addItem(anItem);
    anItem = new ItemPane(null, Messages.messages[16]);
    itemContainer.addItem(anItem);
    anItem = new ItemPane(null, Messages.messages[17]);
    itemContainer.addItem(anItem);
    anItem = new ItemPane(null, Messages.messages[18]);
    itemContainer.addItem(anItem);

    anItem = new ItemPane("Spoken Production", Messages.messages[19]);
    itemContainer.addItem(anItem);
    anItem = new ItemPane(null, Messages.messages[20]);
    itemContainer.addItem(anItem);

    anItem = new ItemPane("Strategies", Messages.messages[21]);
    itemContainer.addItem(anItem);
    anItem = new ItemPane(null, Messages.messages[22]);
    itemContainer.addItem(anItem);

    anItem = new ItemPane("Writing", Messages.messages[23]);
    itemContainer.addItem(anItem);
    anItem = new ItemPane(null, Messages.messages[24]);
    itemContainer.addItem(anItem);
    anItem = new ItemPane(null, Messages.messages[25]);
    itemContainer.addItem(anItem);
    anItem = new ItemPane(null, Messages.messages[26]);
    itemContainer.addItem(anItem);
    anItem = new ItemPane(null, Messages.messages[27]);
    itemContainer.addItem(anItem);

    return itemContainer;
  }
}