package Lesson3lvl2;

public class TwoElementsSwap <T>{
        T[] array;

        TwoElementsSwap(T[] array) {
            this.array = array;
        }
        TwoElementsSwap(){this.array = array;} //прописываем исключение для элементов, которые заменить не получится

        public void TwoElementsSwap(T[] anyArray, Integer firstPosition, Integer secondPosition) throws WrongPositionException{
            if (firstPosition < 0 || firstPosition > anyArray.length ||
                    secondPosition < 0 || secondPosition > anyArray.length || firstPosition == secondPosition) {
                throw new WrongPositionException("Позиции элементов для замены указаны неверно!");
            }
            T firstElement = anyArray[firstPosition];
            T secondElement = anyArray[secondPosition];
            anyArray[firstPosition] = secondElement;
            anyArray[secondPosition] = firstElement;
        }

    }
