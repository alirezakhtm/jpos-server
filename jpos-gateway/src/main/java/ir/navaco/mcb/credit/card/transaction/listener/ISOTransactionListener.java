package ir.navaco.mcb.credit.card.transaction.listener;

import org.jpos.q2.iso.QServer;

/**
 * Q2 wrapper of an ISOServer, taking an xml configuration file and instancing an ISOServer and passing
 * the attributes to the ISOServer so the ISOServer meets the requirements of the xml definition.
 * Briefly ISOServer is listen in a given port and take care the message and passing control for processing using implementation of ISOChannel
 * the service can have the process to handle request based MTI and route to specific participant (based on MTI)
 *
 * @author sa.gholizadeh <sa.gholizadeh@navaco.ir>
 * @author a.khatamidoost <alireza.khtm@gmail.com>
 */
public class ISOTransactionListener extends QServer {

}
