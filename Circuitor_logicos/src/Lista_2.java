public class Lista_2 {

/*
Questões da lista
1)
         quant_entrada=3
         ----------------
         F1= (!a&&!b) || (a&&b);
         F3=!(F1&&c);
         F2=!(!b||F3);
         F_result=!(F1&&F2);
         Fsimplificada=!a || !b || !c;


2)
        quant_entrada=3
        ----------------
        F3=!(a||b);
        F4=!(((!b)&&c));
        F2=!(F3!=F4);
        F1= !(F3&&F4);
        Boolean F_result=!(F1&&F2);
        Fsimplificada=!a || b || !c;



3)

        quant_entrada=4
 ----------------------------
        F1= !(a||b||c);
        F2=((!c)!=d);
        F_result=!(F1&&F2);
        Fsimplificada=a || b || c || d;

4)
        quant_entrada=4
 ----------------------------
        F3=!(a&&b&&c);
        F4=!(c&&d);
        F2=!(F4||F3);
        F1= !((!c)!=F3);
        F_result=!(F1&&F2);
        Fsimplificada=!a || !b || !c || !d;

    }

 */


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

    public static void geraMapa(int tabela_invertida[]){
        int result[]= new int[tabela_invertida.length], j=0;
        for(int i =tabela_invertida.length-1; i>=0; i--){
            result[j]=tabela_invertida[i];
            j++;
        }
        int map[][]= new  int[tabela_invertida.length/4][4];
        map[0][0]=result[0];
        map[0][1]=result[1];
        map[0][2]=result[3];
        map[0][3]=result[2];
        map[1][0]=result[4];
        map[1][1]=result[5];
        map[1][2]=result[7];
        map[1][3]=result[6];
        if (tabela_invertida.length==16){
            map[2][0]=result[12];
            map[2][1]=result[13];
            map[2][2]=result[15];
            map[2][3]=result[14];
            map[3][0]=result[8];
            map[3][1]=result[9];
            map[3][2]=result[11];
            map[3][3]=result[10];
        }
        System.out.println("Mapa de Karnaugh");
        for (int i=0; i<tabela_invertida.length/4; i++){
            for (j=0; j<4; j++){
                System.out.printf("[ %d ] ", map[i][j]);
            }
            System.out.println("");
        }

    }
    public static void gerarFuncao(int quant_entrada/*quantidade de variaveis de entrada*/){
        Boolean a, b, c, d=false, F1, F2, F3, F4, F_result, Fsimplificada;
        Boolean tabela[][]=geraTabela(quant_entrada);
        int tamanho=(int)Math.pow(2, quant_entrada), cont=0;
        int tabela_invertida[] = new int[tamanho];
        for(int i=0; i<tamanho; i++){
            a=tabela[i][0];
            b=tabela[i][1];
            c=tabela[i][2];
            if(quant_entrada==4)
                d=tabela[i][3];
            //esta parte é destinada para formar a função F descrita na questão
            F3=!(a&&b&&c);
            F4=!(c&&d);
            F2=!(F4||F3);
            F1= !((!c)!=F3);
            F_result=!(F1&&F2);
            Fsimplificada=!a || !b || !c || !d;//versão mais simplificada da funçao
            //esta parte é destinada para formar a função F descrita na questão

            tabela_invertida[i]=F_result?1:0;
            if(Fsimplificada==F_result)
                cont++;
        }
        geraMapa(tabela_invertida);
        System.out.print("A versão simplificada bate com a função: ");
        System.out.printf("%s", (cont==tamanho)?"SIM":"Não");




    }

    public static void main(String[] args) {
        gerarFuncao(4);
    }
}
