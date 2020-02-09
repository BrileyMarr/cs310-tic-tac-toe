package edu.jsu.mcis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class TicTacToeController implements ActionListener {

    private final TicTacToeModel model;
    private final TicTacToeView view;
    
    /* CONSTRUCTOR */

    public TicTacToeController(int width) {
        
        /* Initialize model, view, and width */

        model = new TicTacToeModel(width);
        view = new TicTacToeView(this, width);
        
    }

        public String getMarkAsString(int row, int col) {       
            return (model.getMark(row, col).toString());
        }
        
        public TicTacToeView getView() {       
           return view;       
        }

        @Override
        public void actionPerformed(ActionEvent event) {

            String name = ((JButton) event.getSource()).getName();

            for (int row = 0; row < name; row++) {
            
                for (int col = 0; col < name; col++) {

                    if (model.isXTurn() == true){
                        System.out.println(model.makeMark(row, col));
                    }
                    else if (model.isXTurn() == false){
                        System.out.println(model.makeMark(row, col));
                    }
                }
            }

            view.updateSquares();

            TicTacToeModel.Result result = model.getResult();

            if (result != TicTacToeModel.Result.NONE) {

                view.disableSquares();
                view.showResult(result.toString());
            
            }
            else {
                view.clearResult();
            }

        }

}
