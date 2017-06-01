package TCPCliente;

import br.com.negocio.Veiculo;
import br.com.negocio.ArquivoBD;
import br.com.negocio.Posicao;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TCPClient {

    private static Integer lerTipo()
    {
        Scanner leitor = new Scanner(System.in);
                
        while (true)
        {
            System.out.println("Digite o tipo do veiculo: ");
            System.out.println("1 - Carro");
            System.out.println("2 - Caminhão Toco");
            System.out.println("3 - Caminhão Carreta");
            System.out.println("4 - Caminhão Bitrem");
            System.out.println("5 - Caminhão Treminhão");
            System.out.println("6 - Moto");
            System.out.println("7 - Triciclo");
            System.out.println("8 - Quadriciclo");
            Integer tipo = Integer.parseInt(leitor.nextLine());

            if (tipo >= 9 || tipo < 1)
            {
                System.out.println("Tipo Invalido");
                continue;
            }
            else
            {
                return tipo;
            }
        }
    }
    
    private static String formataTipo(Integer tipo)
    {
        switch (tipo)
        {
            case 1:
                return "Carro";

            case 2:
                return "Caminhão Toco";

            case 3:
                return "Caminhão Carreta";
                
            case 4:
                return "Caminhão Bitrem";

            case 5:
                return "Caminhão Treminhão";

            case 6:
                return "Moto";

            case 7:
                return "Triciclo";

            case 8:
                return "Quadriciclo";
                    
            default: 
                return "";
        }
    }
    
    private static Veiculo lerVeiculo()
    {
        Scanner leitor = new Scanner(System.in);
        
        Veiculo v = new Veiculo();

        System.out.println("Digite a placa do veiculo, sem formatação: ");
        v.setPlaca(leitor.nextLine());
        
        v.setTipo(lerTipo());

        while (true)
        {
            System.out.println("Digite a Unidade do Veiculo com 5 CARACTERES: ");
            String unidade = leitor.nextLine();

            if (unidade.length() != 5)
            {
                System.out.println("Unidade deve ter 5 caracteres");
                continue;
            }
            else
            {
                v.setUncapac(unidade);
                break;
            }
        }

        System.out.println("Digite a capacidade do veiculo: ");
        v.setCapacidade(Integer.parseInt(leitor.nextLine()));
        
        return v;
    }
    
    public static ArquivoBD comunicar (Socket s,
                                       ArquivoBD a) throws Exception
    {
        ObjectOutputStream esc = new ObjectOutputStream(s.getOutputStream());
        esc.writeObject(a);
        esc.flush();
        
        ObjectInputStream inp = new ObjectInputStream(s.getInputStream());
        return (ArquivoBD) inp.readObject();
    }
    
    public static void main(String[] args){
        try {
            Scanner leitor = new Scanner(System.in);
            
            int porta = 2010;
            
            Socket s = new Socket("localhost", porta);
            System.out.println("Cliente conectado ao servidor na porta " + porta + "\n");
            
            while (true)
            {
                System.out.println("1 - Adicionar Veiculo");
                System.out.println("2 - Alterar Veiculo");
                System.out.println("3 - Excluir Veiculo");
                System.out.println("4 - Consultar Veiculo");
                System.out.println("5 - Listar veiculos por tipo");
                System.out.println("6 - Localização do Veiculo");
                System.out.println("7 - Sair e fechar conexão");
                System.out.println("Digite o código da operação: ");
                Integer operacao = Integer.parseInt(leitor.nextLine());
                
                Veiculo v = new Veiculo();
                ArquivoBD arquivo = new ArquivoBD();
                List<Object> l = new ArrayList<Object>();
                
                switch (operacao)
                {
                    case 1:
                        v = lerVeiculo();
                        l.add(v);
                        
                        arquivo.setOpe(operacao);
                        arquivo.setObjetos(l);
                        
                        arquivo = comunicar(s, arquivo);
                        
                        if (arquivo.getCode() == 0)
                        {
                            System.out.println(arquivo.getRetorno());
                        }
                        else if (arquivo.getCode() == 1)
                        {
                            System.out.println("Erro: " + arquivo.getRetorno());
                        }
                        break;
                        
                    case 2:
                        v = lerVeiculo();
                        
                        arquivo.setOpe(operacao);
                        arquivo.setObjetos(l);
                        
                        arquivo = comunicar(s, arquivo);
                        
                        if (arquivo.getCode() == 0)
                        {
                            System.out.println(arquivo.getRetorno());
                        }
                        else if (arquivo.getCode() == 1)
                        {
                            System.out.println("Erro: " + arquivo.getRetorno());
                        }
                        break;
                        
                    case 3:
                        System.out.println("Digite a placa do veiculo, sem formatação: ");
                        v.setPlaca(leitor.nextLine());
                        
                        l.add(v);
                        arquivo.setOpe(operacao);
                        arquivo.setObjetos(l);
                        
                        arquivo = comunicar(s, arquivo);
                        
                        if (arquivo.getCode() == 0)
                        {
                            System.out.println(arquivo.getRetorno());
                        }
                        else if (arquivo.getCode() == 1)
                        {
                            System.out.println("Erro: " + arquivo.getRetorno());
                        }
                        break;
                        
                    case 4:
                        System.out.println("Digite a placa do veiculo, sem formatação: ");
                        v.setPlaca(leitor.nextLine());
                        
                        l.add(v);
                        arquivo.setOpe(operacao);
                        arquivo.setObjetos(l);
                        
                        arquivo = comunicar(s, arquivo);
                        
                        if (arquivo.getCode() == 0)
                        {
                            v = (Veiculo) arquivo.getObjetos().get(0);
                            
                            System.out.println("Placa: " + v.getPlaca());
                            System.out.println("Capacidade: " + v.getCapacidade());
                            System.out.println("Tipo: " + formataTipo(v.getTipo()));
                            System.out.println("Unidade: " + v.getUncapac());
                        }
                        else if (arquivo.getCode() == 1)
                        {
                            System.out.println("Erro: " + arquivo.getRetorno());
                        }
                        
                        break;
                        
                    case 5:
                        v.setTipo(lerTipo());
                        
                        l.add(v);
                        arquivo.setOpe(operacao);
                        arquivo.setObjetos(l);
                        
                        arquivo = comunicar(s, arquivo);
                        
                        if (arquivo.getCode() == 0)
                        {
                            System.out.println("Tipo: " + formataTipo(v.getTipo()));
                            System.out.println("-----------------------------------------------------------");
                            
                            for (Object vei : arquivo.getObjetos())
                            {
                                v = (Veiculo) vei;
                                
                                System.out.print("Placa: " + v.getPlaca());
                                System.out.print(" Capacidade: " + v.getCapacidade());
                                System.out.print(" Tipo: " + formataTipo(v.getTipo()));
                                System.out.print(" Unidade: " + v.getUncapac());
                                System.out.println("-----------------------------------------------------------");
                            }
                        }
                        else if (arquivo.getCode() == 1)
                        {
                            System.out.println("Erro: " + arquivo.getRetorno());
                        }
                        break;
                        
                    case 6:
                        System.out.println("Digite a placa do veiculo, sem formatação: ");
                        v.setPlaca(leitor.nextLine());
                        
                        System.out.println("Digite a data da localização(Formato DD/MM/YYYY HH:MM:SS), ou deixe-a em branco para pegar todas as localizações");
                        String data = leitor.nextLine();
                        
                        if (!data.equals(""))
                        {
                            Calendar cal = Calendar.getInstance();
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss", Locale.ENGLISH);
                            cal.setTime(sdf.parse(data));
                            arquivo.setData(cal);
                        }
                        
                        l.add(v);
                        arquivo.setObjetos(l);
                        
                        arquivo = comunicar(s, arquivo);
                        
                        if (arquivo.getCode() == 0)
                        {
                            System.out.println("Veiculo: " + v.getPlaca());
                            System.out.println("-----------------------------------------------------------");
                            
                            for (Object pos : arquivo.getObjetos())
                            {
                                Posicao p = (Posicao) pos;
                                
                                System.out.print("Data: " + p.getDatahora().toString());
                                System.out.print(" Latitude: " + p.getLatitude());
                                System.out.print(" Longitude: " + p.getLongitude());
                                System.out.println("-----------------------------------------------------------");
                            }
                        }
                        else if (arquivo.getCode() == 1)
                        {
                            System.out.println("Erro: " + arquivo.getRetorno());
                        }
                        break;
                        
                    case 7:
                        s.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Operação Inválida");
                        break;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
