    package Lesson5.Presenter.Commands;

    import Lesson5.Model.Model;
    import Lesson5.Model.User;
    import Lesson5.Presenter.Presenter;
    import Lesson5.View.View;
    

    public class ChangePassword_Command implements ICommand {
        public ChangePassword_Command(View view, Presenter presenter, Model model, User user) {
            this.view = view;
            this.presenter = presenter;
            this.model = model;
            this.user = user;
        }
    
        @Override
        public String get_command() {
            return "changePassword";
        }
    
        @Override
        public String get_description() {
            return "Смена пароля.";
        }
    
        @Override
        public void Exercute() {
            view.print("************** " + get_command() + "************** ");
            view.print("Введите старый пароль:");
            String oldpassword = view.input();

            view.print("Введите новый пароль:");
            String newpassword = view.input();
            if (user.changePassword(newpassword, oldpassword)) {
                view.print("Пароль успешно изменен!");
                return;
            }
            view.print("Неверный логин или пароль...");
        }
    
        private View view;
        private Model model;
        private Presenter presenter;
        private User user;
    }
    
