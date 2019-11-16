<%@page import = "dao.CallServer" %>

<!-- JSP Responsavel pela conexão com o java -->

<% 

    if (request.getParameter("msnCliente") != null) {
        String callCliente = request.getParameter("msnCliente");
        
        CallServer conectSocket = new CallServer();

        String msnServer = null;
        
            switch (callCliente) {
                case "Limpar":
                    msnServer = conectSocket.callServidor("gtk-c1");
                    out.print(msnServer);
                    break;

                case "Normal":
                    msnServer = conectSocket.callServidor("gtk-c2");
                    out.print(msnServer);
                    break;

                case "Preferencial":
                    msnServer = conectSocket.callServidor("gtk-c3");
                    out.print(msnServer);
                    break;

                case "Atender":
                    msnServer = conectSocket.callServidor("gtk-c4");
                    out.print(msnServer);
                    break;

                case "chamado":
                    msnServer = conectSocket.callServidor("gtk-c5");
                    out.print(msnServer);
                    break;
                default:
                out.println("Mensagem invalido!");

            }
           
    }
%> 