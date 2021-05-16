public class Lista_2 {

    public static Boolean compara1(Boolean a, Boolean b, Boolean c){
        Boolean f1= (!a&&!b) || (a&&b);
        Boolean f3=!(f1&&c);
        Boolean f2=!(!b||f3);
        Boolean F=!(f1&&f2);
        Boolean simplificada=!a || !b || !c;
        return F==simplificada;
    }

    public static Boolean compara2(Boolean a, Boolean b, Boolean c){

        Boolean f3=!(a||b);
        Boolean f4=!(((!b)&&c));
        Boolean f2=!(f3!=f4);
        Boolean f1= !(f3&&f4);
        Boolean F=!(f1&&f2);
        Boolean simplificada=!a || b || !c;
        return F==simplificada;
    }
    public static Boolean compara3(Boolean a, Boolean b, Boolean c, Boolean d){
        Boolean f1= !(a||b||c);
        Boolean f2=((!c)!=d);
        Boolean F=!(f1&&f2);
        Boolean simplificada=a || b || c || d;
        return F==simplificada;
    }
    public static Boolean compara4(Boolean a, Boolean b, Boolean c, Boolean d){

        Boolean f3=!(a&&b&&c);
        Boolean f4=!(c&&d);
        Boolean f2=!(f4||f3);
        Boolean f1= !((!c)!=f3);
        Boolean F=!(f1&&f2);
        Boolean simplificada=!a || !b || !c || !d;
        return F==simplificada;
    }
    public static Boolean[][] geraTabela(int qtd){
        Boolean tabela[][]= new Boolean[(int)Math.pow(2,qtd)][qtd];
        Boolean valor;
        int parametro= (int)Math.pow(2,qtd-1);
        for (int i=0; i<qtd; i++){
            valor=false;
            for(int j=0; j<(int)Math.pow(2,qtd); j++){
                if((j)%parametro==0){
                    valor=!valor;
                }
                tabela[j][i]=valor;
            }
            parametro/=2;
        }

        return  tabela;
    }

    public static void main(String[] args) {
        Boolean [][]t3=geraTabela(3);
        Boolean [][]t4=geraTabela(4);
        int cont=0;
        for (int i=0; i<8;i++){
            if(compara2(t3[i][0], t3[i][1], t3[i][2])){
                cont++;
            }
            else{
                System.out.println(i);
            }
        }
        if(cont==8){
            System.out.println("bateu");
        }
        cont=0;
        for (int i=0; i<16;i++){
            if(compara4(t4[i][0], t4[i][1], t4[i][2], t4[i][3])){
                cont++;
            }
            else{
                System.out.println(i);
            }
        }
        if(cont==16){
            System.out.println("bateu");
        }

    }

}
