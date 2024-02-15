
package ClientOfHotel;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ClientOfHotel package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Booking_QNAME = new QName("http://services/", "Booking");
    private final static QName _SearchByID_QNAME = new QName("http://services/", "SearchByID");
    private final static QName _Show_QNAME = new QName("http://services/", "Show");
    private final static QName _BookingResponse_QNAME = new QName("http://services/", "BookingResponse");
    private final static QName _SearchByIDResponse_QNAME = new QName("http://services/", "SearchByIDResponse");
    private final static QName _ShowReservation_QNAME = new QName("http://services/", "ShowReservation");
    private final static QName _ShowResponse_QNAME = new QName("http://services/", "ShowResponse");
    private final static QName _ShowReservationResponse_QNAME = new QName("http://services/", "ShowReservationResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ClientOfHotel
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ShowReservation }
     * 
     */
    public ShowReservation createShowReservation() {
        return new ShowReservation();
    }

    /**
     * Create an instance of {@link ShowResponse }
     * 
     */
    public ShowResponse createShowResponse() {
        return new ShowResponse();
    }

    /**
     * Create an instance of {@link ShowReservationResponse }
     * 
     */
    public ShowReservationResponse createShowReservationResponse() {
        return new ShowReservationResponse();
    }

    /**
     * Create an instance of {@link Booking }
     * 
     */
    public Booking createBooking() {
        return new Booking();
    }

    /**
     * Create an instance of {@link SearchByID }
     * 
     */
    public SearchByID createSearchByID() {
        return new SearchByID();
    }

    /**
     * Create an instance of {@link Show }
     * 
     */
    public Show createShow() {
        return new Show();
    }

    /**
     * Create an instance of {@link BookingResponse }
     * 
     */
    public BookingResponse createBookingResponse() {
        return new BookingResponse();
    }

    /**
     * Create an instance of {@link SearchByIDResponse }
     * 
     */
    public SearchByIDResponse createSearchByIDResponse() {
        return new SearchByIDResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Booking }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "Booking")
    public JAXBElement<Booking> createBooking(Booking value) {
        return new JAXBElement<Booking>(_Booking_QNAME, Booking.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchByID }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "SearchByID")
    public JAXBElement<SearchByID> createSearchByID(SearchByID value) {
        return new JAXBElement<SearchByID>(_SearchByID_QNAME, SearchByID.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Show }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "Show")
    public JAXBElement<Show> createShow(Show value) {
        return new JAXBElement<Show>(_Show_QNAME, Show.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "BookingResponse")
    public JAXBElement<BookingResponse> createBookingResponse(BookingResponse value) {
        return new JAXBElement<BookingResponse>(_BookingResponse_QNAME, BookingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchByIDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "SearchByIDResponse")
    public JAXBElement<SearchByIDResponse> createSearchByIDResponse(SearchByIDResponse value) {
        return new JAXBElement<SearchByIDResponse>(_SearchByIDResponse_QNAME, SearchByIDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowReservation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "ShowReservation")
    public JAXBElement<ShowReservation> createShowReservation(ShowReservation value) {
        return new JAXBElement<ShowReservation>(_ShowReservation_QNAME, ShowReservation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "ShowResponse")
    public JAXBElement<ShowResponse> createShowResponse(ShowResponse value) {
        return new JAXBElement<ShowResponse>(_ShowResponse_QNAME, ShowResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowReservationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "ShowReservationResponse")
    public JAXBElement<ShowReservationResponse> createShowReservationResponse(ShowReservationResponse value) {
        return new JAXBElement<ShowReservationResponse>(_ShowReservationResponse_QNAME, ShowReservationResponse.class, null, value);
    }

}
