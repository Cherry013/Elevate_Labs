import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ToDoApp extends JFrame {

    // --- Data model for a task ---
    static class Task {
        String text;
        Date selectedDate;   // chosen date (calendar)
        Date addedAt;        // time the task was added

        Task(String text, Date selectedDate, Date addedAt) {
            this.text = text;
            this.selectedDate = selectedDate;
            this.addedAt = addedAt;
        }
    }

    // --- Custom renderer: left = task text, right = date (top) + time (bottom) ---
    static class TaskRenderer extends JPanel implements ListCellRenderer<Task> {
        private final JLabel taskLabel = new JLabel();
        private final JLabel dateLabel = new JLabel();
        private final JLabel timeLabel = new JLabel();
        private final SimpleDateFormat dateFmt = new SimpleDateFormat("dd-MM-yyyy");
        private final SimpleDateFormat timeFmt = new SimpleDateFormat("HH:mm:ss");

        TaskRenderer() {
            setLayout(new BorderLayout(12, 0));
            setBorder(new EmptyBorder(8, 10, 8, 10));

            // Left side: task text
            taskLabel.setFont(taskLabel.getFont().deriveFont(Font.PLAIN, 14f));
            taskLabel.setVerticalAlignment(SwingConstants.CENTER);

            // Right side: stacked date over time, right-aligned
            JPanel right = new JPanel(new GridLayout(2, 1, 0, 2));
            right.setOpaque(false);
            dateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            timeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            dateLabel.setFont(dateLabel.getFont().deriveFont(Font.BOLD));
            right.add(dateLabel);
            right.add(timeLabel);

            add(taskLabel, BorderLayout.CENTER);
            add(right, BorderLayout.EAST);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends Task> list, Task value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            if (value != null) {
                taskLabel.setText(value.text);
                dateLabel.setText("Date: " + (value.selectedDate != null ? dateFmt.format(value.selectedDate) : "-"));
                timeLabel.setText("Added at: " + (value.addedAt != null ? timeFmt.format(value.addedAt) : "-"));
            } else {
                taskLabel.setText("");
                dateLabel.setText("Date: -");
                timeLabel.setText("Added at: -");
            }

            // Selection colors
            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
                taskLabel.setForeground(list.getSelectionForeground());
                dateLabel.setForeground(list.getSelectionForeground());
                timeLabel.setForeground(list.getSelectionForeground());
                setOpaque(true);
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
                taskLabel.setForeground(list.getForeground());
                dateLabel.setForeground(new Color(60, 60, 60));
                timeLabel.setForeground(new Color(90, 90, 90));
                setOpaque(true);
            }

            return this;
        }
    }

    // --- UI Fields ---
    private final DefaultListModel<Task> model = new DefaultListModel<>();
    private final JList<Task> list = new JList<>(model);
    private final JTextField taskField = new JTextField();
    private final JSpinner dateSpinner;

    public ToDoApp() {
        super("To-Do List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 450);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(0, 8));

        // Date spinner (calendar-like, built-in)
        SpinnerDateModel dateModel = new SpinnerDateModel(new Date(), null, null, java.util.Calendar.DAY_OF_MONTH);
        dateSpinner = new JSpinner(dateModel);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "dd-MM-yyyy");
        dateSpinner.setEditor(dateEditor);
        dateSpinner.setPreferredSize(new Dimension(120, dateSpinner.getPreferredSize().height));

        JButton addBtn = new JButton("Add Task");
        JButton delBtn = new JButton("Delete");

        // Top panel with two rows
        JPanel top = new JPanel();
        top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
        top.setBorder(new EmptyBorder(10, 10, 0, 10));

        // Row 1: Task label + field
        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 5));
        row1.add(new JLabel("Task:"));
        taskField.setPreferredSize(new Dimension(350, 28)); // long input field
        row1.add(taskField);

        // Row 2: Date label + calendar + buttons
        JPanel row2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 5));
        row2.add(new JLabel("Date:"));
        row2.add(dateSpinner);
        row2.add(addBtn);
        row2.add(delBtn);

        // Add both rows to the top panel
        top.add(row1);
        top.add(row2);

        add(top, BorderLayout.NORTH);

        // List setup with custom renderer
        list.setCellRenderer(new TaskRenderer());
        list.setFixedCellHeight(56); // enough room for two lines on the right
        add(new JScrollPane(list), BorderLayout.CENTER);

        // Actions
        addBtn.addActionListener(this::onAdd);
        delBtn.addActionListener(this::onDelete);

        // Enter to add
        taskField.addActionListener(this::onAdd);
    }

    private void onAdd(ActionEvent e) {
        String text = taskField.getText().trim();
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a task.", "Missing Task", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Date chosen = (Date) dateSpinner.getValue();
        model.addElement(new Task(text, chosen, new Date()));
        taskField.setText("");
        taskField.requestFocusInWindow();
    }

    private void onDelete(ActionEvent e) {
        int idx = list.getSelectedIndex();
        if (idx < 0) {
            JOptionPane.showMessageDialog(this, "Select a task to delete.", "No Selection", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        model.remove(idx);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ToDoApp().setVisible(true));
    }
}
