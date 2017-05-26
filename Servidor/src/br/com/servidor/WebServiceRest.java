package br.com.servidor;

import br.com.DAO.PosicaoDAO;
import br.com.DAO.VeiculoDAO;
import br.com.negocio.Posicao;
import br.com.negocio.Veiculo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author RastreaMentos
 */
@Path("mentos")
public class WebServiceRest {

    @Context
    private UriInfo context;

    public WebServiceRest() {
    }

    @POST
    @Path("/post/incluir-veiculo")
    @Consumes(MediaType.APPLICATION_JSON)
    public Boolean adicionarVeiculo(@FormParam("dsPlaca") String dsPlaca,
            @FormParam("idTipo") Integer idTipo,
            @FormParam("vlCapacidade") Integer vlCapacidade,
            @FormParam("dsUnidade") String dsUnidade) throws Exception {
        try {
            Veiculo v = new Veiculo(dsPlaca, idTipo, vlCapacidade, dsUnidade);
            VeiculoDAO vdao = new VeiculoDAO();
            vdao.incluir(v);
            return true;
        } catch (SQLException e) {
            throw new Exception("Não foi possivel inserir o veículo.");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @PUT
    @Path("/put/alterar-veiculo")
    @Consumes(MediaType.APPLICATION_JSON)
    public Boolean alterarVeiculo(@FormParam("cdVeiculo") Integer cdVeiculo,
            @FormParam("cdVeiculo") String dsPlaca,
            @FormParam("idTipo") Integer idTipo,
            @FormParam("vlCapacidade") Integer vlCapacidade,
            @FormParam("dsUnidade") String dsUnidade) throws Exception {
        try {
            Veiculo v = new Veiculo(cdVeiculo, dsPlaca, idTipo, vlCapacidade, dsUnidade);
            VeiculoDAO vdao = new VeiculoDAO();
            vdao.alterar(v);
            return true;
        } catch (SQLException e) {
            throw new Exception("Não foi possivel alterar o veículo.");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    @DELETE
    @Path("/delete/excluir-veiculo/{cdVeiculo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Boolean excluirVeiculo(@PathParam("cdVeiculo") Integer cdVeiculo) throws Exception{
        try {
            Veiculo veiculo = new Veiculo(cdVeiculo);
            VeiculoDAO vdao = new VeiculoDAO();
            vdao.excluir(veiculo);
            return true;
        }  catch (SQLException e) {
            throw new Exception("Não foi possivel excluir o veículo.");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    @GET
    @Path("/get/consultar-veiculo/{cdVeiculo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Veiculo consultarVeiculo(@PathParam("cdVeiculo")  Integer cdVeiculo) throws Exception{
        try {
            VeiculoDAO vdao = new VeiculoDAO();
            Veiculo veiculo = vdao.consultarVeiculo(cdVeiculo);
            return veiculo;
        } catch (Exception ex) {
            throw new Exception("Não foi possivel consultar o veículo");
        }
    }
    
    @GET
    @Path("/get/listar-tipo/{idTipo}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> listaTipo(@PathParam("idTipo")  Integer idTipo) throws Exception{
        try {
            VeiculoDAO vdao = new VeiculoDAO();
            List<Veiculo> list = vdao.consultarVeiculosPorTipo(idTipo);

            for (Veiculo v : list) {
                v.setPosicoes(null);
            }
            return list;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
//    @GET
//    @Path("/get/localizacao/{cdVeiculo}/{dtLocalizacao}")
//    public List<Posicao> localizacao(@PathParam("idTipo") Integer cdVeiculo,
//            @PathParam("dtLocalizacao") Calendar dtLocalizacao) throws Exception {
//        try {
//            PosicaoDAO pdao = new PosicaoDAO();
//            List<Posicao> list = new ArrayList<Posicao>();
//                    
//            if (dtLocalizacao == null)
//            {
//                list = pdao.consultarPosicoesCarro(cdVeiculo);
//            }
//            else
//            {
//                Posicao p = pdao.consultarPosicao(cdVeiculo, dtLocalizacao);
//                
//                list.add(p);
//            }
//            
//            for (Posicao p : list) {
//                p.setVeiculo(null);
//            }
//            
//            return list;
//            
//        } catch (Exception ex) {
//            throw new Exception(ex.getMessage());
//        }
//    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
